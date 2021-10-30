package com.enit.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enit.soa.domain.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
