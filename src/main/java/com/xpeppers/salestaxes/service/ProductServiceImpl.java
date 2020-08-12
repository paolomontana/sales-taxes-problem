package com.xpeppers.salestaxes.service;

import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Product getProductByName(String name) {
    return productRepository.findByName(name);
  }
}
