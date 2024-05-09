package com.graphqlspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GraphqlSpringbootApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testGetSellers() {
        // Create GraphQL query
        String query = "{ sellers(filter: {searchByName: \"Amazon\"}, page: {page: 0, size: 10}, sortBy: NAME_ASC) { data { sellerName externalId producerSellerStates { producerId producerName sellerState sellerId } marketplaceId } } }";

        // Send GraphQL request
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/graphql", new HttpEntity<>(query), String.class);

        // Assert response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions based on the expected response data
    }

}
