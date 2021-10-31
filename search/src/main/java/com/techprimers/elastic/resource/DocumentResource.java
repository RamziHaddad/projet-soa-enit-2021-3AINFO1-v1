package com.techprimers.elastic.resource;

import com.techprimers.elastic.model.Product;
import com.techprimers.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentResource {

    @Autowired
    ProductRepository productRepository;


    @PostMapping("/save")
    public void saveProduct(@RequestBody Product p) {

        productRepository.save(p);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product p) {
        productRepository.save(p);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id) {
        System.out.println(productRepository.existsById(id));
            productRepository.deleteById(id);
    }





}
