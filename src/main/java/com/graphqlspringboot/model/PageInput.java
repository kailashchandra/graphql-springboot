package com.graphqlspringboot.model;

import lombok.Data;

@Data
public class PageInput {
	private int page;
    private int size;
}
