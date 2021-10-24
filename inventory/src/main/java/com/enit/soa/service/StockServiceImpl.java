package com.enit.soa.service;

import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import com.enit.soa.domain.Product;
import com.enit.soa.domain.Stock;
import com.enit.soa.repository.ProductRepository;
import com.enit.soa.repository.StockRepository;

@ApplicationScoped
public class StockServiceImpl implements StockService {

	@Inject
	StockRepository em;


	@Override
	@Transactional

	public void deleteStock(long stockId) {
		em.deleteById(stockId);
	}

	@Override
	public Stock editStock(long stockId, int quantity) throws Exception {
		Optional<Stock> stock = em.findById(stockId);
		if (stock.isPresent()) {
			stock.get().setQuantity(quantity);
			em.save(stock.get());
			return stock.get();
		}
		throw new Exception("stock not Found!");
	}

	@Override
	public Stock addStock(Stock stock) throws Exception {
		Stock save = em.save(stock);
		return save;
	}

	@Override
	public List<Stock> findStock() {
		return em.findAll();
	}





}
