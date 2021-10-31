package com.techprimers.elastic.resource;

import com.techprimers.elastic.model.Product;
import com.techprimers.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/description/{text}")
    public List<Product> searchDescription(@PathVariable final String text) {
        return productRepository.findByDescription(text);
    }

    @GetMapping(value = "/all")
    public List<Product> searchAll() {
        List<Product> productsList = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        products.forEach(productsList::add);
        return productsList;
    }

    @GetMapping(value = "/similar/{id}")
    public List<Product> searchSimilar(@PathVariable Long id) {
        Product prod = productRepository.findById(id);
        return productRepository.findByDescription(prod.getDescription());
    }



}
