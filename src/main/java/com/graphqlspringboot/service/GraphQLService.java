package com.graphqlspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graphql.ExecutionResult;
import graphql.GraphQL;

@Service
public class GraphQLService {
	
    @Autowired
    private GraphQL graphQL;

    public ExecutionResult executeQuery(String query) {
        return graphQL.execute(query);
    }
}

