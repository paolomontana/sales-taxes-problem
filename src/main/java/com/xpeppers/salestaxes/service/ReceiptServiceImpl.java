package com.xpeppers.salestaxes.service;

import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.entity.Receipt;
import com.xpeppers.salestaxes.property.Property;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService {
  @Autowired
  Property property;


  @Override
  public Receipt getReceipt(List<Product> products) {
    Receipt receipt = new Receipt();
    float totalTax = 0;
    float totalOriginalPriceProducts = 0;
    for (Product product : products) {
      float taxProduct = getTaxFromProduct(product);
      float originalPrice = product.getOriginalPrice();
      product.setPrice((float)(Math.round((originalPrice + taxProduct) * product.getQuantity() * 100.0) / 100.0));
      totalTax += taxProduct * product.getQuantity();
      totalOriginalPriceProducts += originalPrice*product.getQuantity();
      receipt.addProduct(product);
    }
    receipt.setTaxes(totalTax);
    receipt.setTotal(totalOriginalPriceProducts + totalTax);

    return receipt;
  }

  private float getTaxFromProduct(Product product) {
    float totalTax = 0;
    if (product.isTaxed()) {
      float tax = (product.getOriginalPrice() * property.getBasic()) / 100;
      totalTax += Math.ceil(tax * 20) / 20; 
    }
    if (product.isImported()) {
      float tax = (product.getOriginalPrice() * property.getDuty()) / 100;
      totalTax += Math.ceil(tax * 20) / 20; 
    }
    return totalTax;
  }

  
}
