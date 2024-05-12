package com.graphqlspringboot.configuration;

import graphql.GraphQL;
import graphql.kickstart.tools.SchemaParser;
import graphql.kickstart.tools.SchemaParserOptions;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.graphqlspringboot.components.QueryResolver;

@Configuration
public class GraphQLConfig {

    @Bean
    GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Bean
     GraphQLSchema graphQLSchema(QueryResolver queryResolver) {
    	SchemaParserOptions options = SchemaParserOptions.newOptions().build();
        return SchemaParser.newParser()
                .file("schema.graphqls") 
                .resolvers(queryResolver)
                .options(options)
                .build()
                .makeExecutableSchema();
    
    }

}
