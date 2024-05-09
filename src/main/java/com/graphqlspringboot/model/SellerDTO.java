package com.graphqlspringboot.model;

import java.util.List;

import lombok.Data;

@Data
public class SellerDTO {

	private String sellerName;
    private String externalId;
    private String marketplaceId;
    private List<ProducerSellerState> producerSellerStates;
}
