package com.graphqlspringboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqlspringboot.entity.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, UUID> {

}
