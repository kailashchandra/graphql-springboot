package com.graphqlspringboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.graphqlspringboot.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, UUID>, JpaSpecificationExecutor<Seller>  {

}
