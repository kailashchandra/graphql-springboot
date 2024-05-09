package com.graphqlspringboot.model;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class SellerFilter {
	private String searchByName;
    private List<UUID> producerIds;
    private List<String> marketplaceIds;
}
