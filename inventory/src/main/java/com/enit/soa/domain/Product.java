package com.enit.soa.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
    @JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Stock stock;
		


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}


}
