package com.graphqlspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqlspringboot.entity.Marketplace;

@Repository
public interface MarketplaceRepository extends JpaRepository<Marketplace, String> {

}
