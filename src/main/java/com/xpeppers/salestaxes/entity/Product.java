package com.xpeppers.salestaxes.entity;

public class Product {
  private String name;
  private float price;
  private float originalPrice;
  private boolean taxed;
  private boolean imported;
  private int quantity;

  public Product(
    String name,
    float originalPrice,
    int quantity,
    boolean taxed,
    boolean imported
  ) {
    setName(name);
    setOriginalPrice(originalPrice);
    setTaxed(taxed);
    setImported(imported);
    setQuantity(quantity);
  }

  public float getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(float originalPrice) {
    this.originalPrice = originalPrice;
  }

  public boolean isTaxed() {
    return taxed;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public boolean isImported() {
    return imported;
  }

  public void setImported(boolean imported) {
    this.imported = imported;
  }

  public void setTaxed(boolean taxed) {
    this.taxed = taxed;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
