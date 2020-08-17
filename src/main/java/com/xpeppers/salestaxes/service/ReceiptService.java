package com.xpeppers.salestaxes.service;

import java.util.List;

import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.entity.Receipt;

public interface ReceiptService {
  public Receipt getReceipt(List<Product> products);
}
