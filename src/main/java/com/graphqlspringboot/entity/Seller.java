package com.graphqlspringboot.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "producer_id")
	private Producer producer;

	@ManyToOne
	@JoinColumn(name = "seller_info_id")
	private SellerInfo sellerInfo;

	private String state;

    private String sellerName;
}
