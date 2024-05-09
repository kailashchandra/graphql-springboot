package com.graphqlspringboot.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Producer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    // Other fields and methods

    @OneToMany(mappedBy = "producer")
    private List<Seller> sellers;
}
