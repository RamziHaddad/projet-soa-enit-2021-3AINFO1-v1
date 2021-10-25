package com.AOS.search.service;

public class Product {
  private final long id;
  private final String description;
  private final String category;
  private final String name;


  public Product(long id, String description, String category, String name) {
    this.id = id;
    this.description = description;
    this.category = category;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public String getCategory() {
    return category;
  }

  public String getName() { return name; }
}
