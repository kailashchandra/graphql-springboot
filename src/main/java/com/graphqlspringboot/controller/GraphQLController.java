package com.graphqlspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphqlspringboot.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/graphql")
public class GraphQLController {
	
    @Autowired
    private GraphQLService graphQLService;

    @PostMapping
    public ResponseEntity<Object> executeQuery(@RequestBody String query) {
        ExecutionResult executionResult = graphQLService.executeQuery(query);
        return ResponseEntity.ok(executionResult);
    }
}
