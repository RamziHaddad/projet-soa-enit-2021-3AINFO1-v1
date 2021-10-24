package com.enit.soa.service;

import java.util.Optional;

import com.enit.soa.domain.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	public Optional<Product> getProduct(long id);
}
