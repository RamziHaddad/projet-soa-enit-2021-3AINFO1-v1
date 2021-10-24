package com.enit.soa.controller;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.enit.soa.domain.Product;
import com.enit.soa.service.ProductService;

@Path("/api/product")
public class ProductController {
	

	@Inject
	ProductService productService;
	
	@POST
	public Product addProduct() {
		return productService.addProduct(null);
	}

}
