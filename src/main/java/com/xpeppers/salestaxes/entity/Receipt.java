package com.xpeppers.salestaxes.entity;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
  private List<Product> products;
  private float taxes;
  private float total;

  public Receipt() {
    products = new ArrayList<Product>();
  }

  public float getTaxes() {
    return taxes;
  }

  public void setTaxes(float taxes) {
    this.taxes = taxes;
  }

  public List<Product> getProducts() {
    return products;
  }

  public float getTotal() {
    return total;
  }

  public void setTotal(float total) {
    this.total = total;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public void addProduct(Product p) {
    this.products.add(p);
  }
}
