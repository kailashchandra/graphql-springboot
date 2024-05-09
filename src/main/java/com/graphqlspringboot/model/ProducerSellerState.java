package com.graphqlspringboot.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProducerSellerState {
	private UUID producerId;
    private String producerName;
    private SellerState sellerState;
    private UUID sellerId;
}
