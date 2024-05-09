package com.graphqlspringboot.model;

import lombok.Data;

@Data
public class PageMeta {

	private int pageNumber;
    private int pageSize;
    private long totalElements;

    public PageMeta(int pageNumber, int pageSize, long totalElements) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }
}
