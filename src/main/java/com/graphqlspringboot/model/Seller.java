package com.graphqlspringboot.model;

import java.util.List;

import lombok.Data;

@Data
public class Seller {

	private String sellerName;
    private String externalId;
    private List<ProducerSellerState> producerSellerStates;
    private String marketplaceId;
}
