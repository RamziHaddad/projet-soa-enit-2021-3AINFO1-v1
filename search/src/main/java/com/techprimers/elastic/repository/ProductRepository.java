package com.techprimers.elastic.repository;

import com.techprimers.elastic.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
    List<Product> findByDescription(String text);
    Product findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);
}
