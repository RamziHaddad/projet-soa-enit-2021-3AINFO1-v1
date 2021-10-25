package com.enit.soa.domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="stock")
public class Stock {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
	private int quantity;
	
	
	@OneToOne(mappedBy = "stock")
	private Product product;
	
	
	
   
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Stock( Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public Stock() {
		
	}

		
}
