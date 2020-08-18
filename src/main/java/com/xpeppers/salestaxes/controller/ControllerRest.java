package com.xpeppers.salestaxes.controller;

import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.entity.Receipt;
import com.xpeppers.salestaxes.service.ReceiptService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {
  @Autowired
  ReceiptService receiptService;

  @GetMapping("/receipt")
  public String getReceipt(@RequestBody String obj) {
    JSONObject json_in = new JSONObject();

    /* Check json format input */
    try {
      json_in = new JSONObject(obj);
    } catch (JSONException ex) {
      return "{ Error: 'malformed json' }";
    }
    JSONArray items = json_in.optJSONArray("products");
    if (items == null) {
      return "{ Error: 'please insert a product list' }";
    }

    List<Product> products = new ArrayList<Product>();

    for (int i = 0; i < items.length(); i++) {
      JSONObject item = (JSONObject) items.get(i);

      String name = item.optString("name");
      float originalPrice = item.optFloat("originalPrice");
      boolean taxed = item.optBoolean("taxed");
      boolean imported = item.optBoolean("imported");
      int quantity = item.optInt("quantity");

      /* Check param product item */
      if (name == null || name.equals("")) {
        return "{ Error: 'name param is required for every product' }";
      }
      if (quantity <= 0) {
        return "{ Error: 'quantity param must be > 0' }";
      }
      if (originalPrice <= 0) {
        return "{ Error: 'price param must be > 0' }";
      }

      Product p = new Product(name, originalPrice, quantity, taxed, imported);

      products.add(p);
    }

    Receipt receipt = receiptService.getReceipt(products);
    return new JSONObject(receipt).toString();
  }
}
