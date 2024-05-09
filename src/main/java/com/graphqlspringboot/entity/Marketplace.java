package com.graphqlspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Marketplace {

	@Id
	private String id;
	private String description;
}
