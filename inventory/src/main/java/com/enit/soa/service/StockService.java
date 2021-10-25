package com.enit.soa.service;

import java.util.List;
import java.util.Optional;

import com.enit.soa.domain.Product;
import com.enit.soa.domain.Stock;

public interface StockService {
	
	public void deleteStock(long stockId);
	public Stock editStock(long stockId, int quantity) throws Exception;
	public Stock addStock(Stock stock) throws Exception;
	public List<Stock> findStock();

	
	
}
