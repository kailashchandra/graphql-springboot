package com.graphqlspringboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.GraphQL;
import graphql.kickstart.tools.SchemaParserOptions;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;

@Configuration
public class GraphQLConfig {
	
    @Bean
    GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return GraphQL.newGraphQL(graphQLSchema).build();
    }
    
    @Bean
    GraphQLSchema graphQLSchema(RuntimeWiring queryResolver, ObjectMapper objectMapper) {
        SchemaParserOptions schemaParserOptions = SchemaParserOptions.newOptions().objectMapperConfigurer((mapper, context) -> {
            // Customize ObjectMapper here if needed
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }).build();

        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(schemaParser.parse("schema.graphqls"), queryResolver);
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
