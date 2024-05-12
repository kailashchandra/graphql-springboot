package com.graphqlspringboot.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphqlspringboot.model.PageInput;
import com.graphqlspringboot.model.SellerFilter;
import com.graphqlspringboot.model.SellerPageableResponse;
import com.graphqlspringboot.model.SellerSortBy;
import com.graphqlspringboot.service.SellerService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {

	@Autowired
    private SellerService sellerService;

    public SellerPageableResponse sellers(SellerFilter filter, PageInput page, SellerSortBy sortBy) {
        return sellerService.getSellers(filter, page, sortBy);
    }
}

