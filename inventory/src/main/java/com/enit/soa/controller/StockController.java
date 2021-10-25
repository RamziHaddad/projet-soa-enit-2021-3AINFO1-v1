package com.enit.soa.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.enit.soa.domain.Product;
import com.enit.soa.domain.Stock;
import com.enit.soa.service.ProductService;
import com.enit.soa.service.StockService;

import dto.UpdateStockRequest;

@Path("/api/stock")
public class StockController {

	
	@Inject
	private StockService stockService; 
	
	
	@POST
	public Stock saveStock(Stock stock ) throws Exception {
		return	stockService.addStock( stock);
		
	}
	
	@PUT
	@Path("/edit/{id}")
	public Stock editStock(@PathParam(value = "id") long id , UpdateStockRequest quantity) throws Exception {
		return stockService.editStock(id, quantity.getQuantity());
	}
	
	
	@DELETE
	public void deleteStock(long id ) {
		 stockService.deleteStock(id);
	}
	
	@GET
	public List<Stock> findById(  ) {
		return stockService.findStock();
	}

	
	
	

}
