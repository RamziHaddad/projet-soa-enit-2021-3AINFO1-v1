package com.techprimers.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product", type = "product", shards = 1)
public class Product {

    private String name;
    private Long id;
    private String description;
    private Long price;
    private String categry;

  public Product() {
  }


  public Product(String name, Long id, String description, Long price, String category) {
    this.name = name;
    this.id = id;
    this.description = description;
    this.price = price;
    this.categry=category;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Long getPrice() {
    return price;
  }

  public String getCategry() { return categry; }
}
