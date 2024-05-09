package com.graphqlspringboot.model;

import java.util.List;

import lombok.Data;

@Data
public class SellerPageableResponse {

	private PageMeta meta;
    private List<SellerDTO> data;
}
