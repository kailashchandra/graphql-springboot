package com.graphqlspringboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqlspringboot.entity.SellerInfo;

@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo, UUID> {

}
