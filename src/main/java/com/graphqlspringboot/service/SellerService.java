package com.graphqlspringboot.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.graphqlspringboot.entity.Producer;
import com.graphqlspringboot.entity.Seller;
import com.graphqlspringboot.model.PageInput;
import com.graphqlspringboot.model.PageMeta;
import com.graphqlspringboot.model.ProducerSellerState;
import com.graphqlspringboot.model.SellerDTO;
import com.graphqlspringboot.model.SellerFilter;
import com.graphqlspringboot.model.SellerPageableResponse;
import com.graphqlspringboot.model.SellerSortBy;
import com.graphqlspringboot.model.SellerState;
import com.graphqlspringboot.repository.SellerRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class SellerService {

	@Autowired
    private SellerRepository sellerRepository;

    public SellerPageableResponse getSellers(SellerFilter filter, PageInput page, SellerSortBy sortBy) {
    	// Create a pageable object for pagination
        Pageable pageable = PageRequest.of(page.getPage(), page.getSize(), getSort(sortBy));

        // Fetch sellers based on filter criteria
        Page<Seller> sellersPage;
        if (filter != null) {
            sellersPage = sellerRepository.findAll(getSpecification(filter), pageable);
        } else {
            sellersPage = sellerRepository.findAll(pageable);
        }

        // Create SellerPageableResponse
        SellerPageableResponse response = new SellerPageableResponse();
        response.setMeta(new PageMeta(sellersPage.getNumber(), sellersPage.getSize(), sellersPage.getTotalElements()));
        response.setData(sellersPage.getContent().stream().map(this::mapToDTO).collect(Collectors.toList()));

        return response;
    }
    
    private Specification<Seller> getSpecification(SellerFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getSearchByName() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("sellerInfo").get("name")),
                        "%" + filter.getSearchByName().toLowerCase() + "%"));
            }
            if (filter.getProducerIds() != null && !filter.getProducerIds().isEmpty()) {
                predicates.add(root.get("producer").get("id").in(filter.getProducerIds()));
            }
            if (filter.getMarketplaceIds() != null && !filter.getMarketplaceIds().isEmpty()) {
                predicates.add(root.get("sellerInfo").get("marketplace").get("id").in(filter.getMarketplaceIds()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private Sort getSort(SellerSortBy sortBy) {
        switch (sortBy) {
            case SELLER_INFO_EXTERNAL_ID_ASC:
                return Sort.by(Sort.Direction.ASC, "sellerInfo.externalId");
            case SELLER_INFO_EXTERNAL_ID_DESC:
                return Sort.by(Sort.Direction.DESC, "sellerInfo.externalId");
            case NAME_ASC:
                return Sort.by(Sort.Direction.ASC, "sellerInfo.name");
            case NAME_DESC:
                return Sort.by(Sort.Direction.DESC, "sellerInfo.name");
            case MARKETPLACE_ID_ASC:
                return Sort.by(Sort.Direction.ASC, "sellerInfo.marketplace.id");
            case MARKETPLACE_ID_DESC:
                return Sort.by(Sort.Direction.DESC, "sellerInfo.marketplace.id");
            default:
                return Sort.unsorted();
        }
    }

    private SellerDTO mapToDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setSellerName(seller.getSellerInfo().getName());
        sellerDTO.setExternalId(seller.getSellerInfo().getExternalId());
        sellerDTO.setProducerSellerStates(mapToProducerSellerStatesDTO(seller.getProducer()));
        sellerDTO.setMarketplaceId(seller.getSellerInfo().getMarketplace().getId());
        return sellerDTO;
    }

    private List<ProducerSellerState> mapToProducerSellerStatesDTO(Producer producer) {
        return producer.getSellers().stream()
                .map(s -> new ProducerSellerState(s.getProducer().getId(), s.getProducer().getName(), SellerState.valueOf(s.getState()), s.getId()))
                .collect(Collectors.toList());
    }
}
