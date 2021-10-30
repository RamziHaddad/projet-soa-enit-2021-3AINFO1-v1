package com.enit.soa.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.enit.soa.domain.Product;
import com.enit.soa.domain.Stock;
import com.enit.soa.repository.ProductRepository;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		Stock stock = new Stock();
		stock.setQuantity(10);
		Product product2 = new Product();
		product2.setStock(stock);
        		        
		return productRepository.save(product2);
	}

	@Override
	public Optional<Product> getProduct(long id) {

		return productRepository.findById(id);
	}

}
