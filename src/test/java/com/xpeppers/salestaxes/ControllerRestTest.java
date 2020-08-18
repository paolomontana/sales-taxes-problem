package com.xpeppers.salestaxes;

import static org.junit.Assert.assertEquals;

import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.entity.Receipt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class ControllerRestTest extends AbstractTest {

  @Override
  @Before
  public void setUp() {
    super.setUp();
  }

  @Test
  public void getReceiptFirstExample() throws Exception {
    /*INPUT*/
    Product p1 = new Product("book", 12.49F, 2, false, false);
    Product p2 = new Product("music CD", 14.99F, 1, true, false);
    Product p3 = new Product("choccolate bar", 0.85F, 1, false, false);

    List<Product> products = new ArrayList<Product>();
    products.add(p1);
    products.add(p2);
    products.add(p3);
    JSONArray jsonArrayInput = new JSONArray(products);
    JSONObject jsonInput = new JSONObject();
    jsonInput.put("products", jsonArrayInput);

    /*EXPETED OUTPUT*/
    Receipt receipt = new Receipt();
    p1.setPrice(24.98F);
    p2.setPrice(16.49F);
    p3.setPrice(0.85F);
    receipt.setProducts(products);
    receipt.setTaxes(1.5F);
    receipt.setTotal(42.32F);

    String uri = "/receipt";

    MvcResult mvcResult = mvc
      .perform(
        MockMvcRequestBuilders
          .get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)
          .content(jsonInput.toString())
      )
      .andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);

    String response = mvcResult.getResponse().getContentAsString();
    String expected = new JSONObject(receipt).toString();

    JSONAssert.assertEquals(expected, response, false);
  }

  @Test
  public void getReceiptSecondExample() throws Exception {
    /*INPUT*/
    Product p1 = new Product("box of choccolate", 10.0F, 1, false, true);
    Product p2 = new Product("bottle of perfume", 47.5F, 1, true, true);

    List<Product> products = new ArrayList<Product>();
    products.add(p1);
    products.add(p2);

    JSONArray jsonArrayInput = new JSONArray(products);
    JSONObject jsonInput = new JSONObject();
    jsonInput.put("products", jsonArrayInput);

    /*EXPETED OUTPUT*/
    Receipt receipt = new Receipt();
    p1.setPrice(10.50F);
    p2.setPrice(54.65F);
    receipt.setProducts(products);
    receipt.setTaxes(7.65F);
    receipt.setTotal(65.15F);

    String uri = "/receipt";

    MvcResult mvcResult = mvc
      .perform(
        MockMvcRequestBuilders
          .get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)
          .content(jsonInput.toString())
      )
      .andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);

    String response = mvcResult.getResponse().getContentAsString();
    String expected = new JSONObject(receipt).toString();

    JSONAssert.assertEquals(expected, response, false);
  }

  @Test
  public void getReceiptThirdExample() throws Exception {
    /*INPUT*/
    Product p1 = new Product(
      "imported bottle of perfume",
      27.99F,
      1,
      true,
      true
    );
    Product p2 = new Product("bottle of porfume", 18.99F, 1, true, false);
    Product p3 = new Product(
      "packet of headache pills",
      9.75F,
      1,
      false,
      false
    );
    Product p4 = new Product(
      "box of imported chocolates",
      11.25F,
      3,
      false,
      true
    );

    List<Product> products = new ArrayList<Product>();
    products.add(p1);
    products.add(p2);
    products.add(p3);
    products.add(p4);
    JSONArray jsonArrayInput = new JSONArray(products);
    JSONObject jsonInput = new JSONObject();
    jsonInput.put("products", jsonArrayInput);

    /*EXPETED OUTPUT*/
    Receipt receipt = new Receipt();
    p1.setPrice(32.19F);
    p2.setPrice(20.89F);
    p3.setPrice(9.75F);
    p4.setPrice(35.55F);
    receipt.setProducts(products);
    receipt.setTaxes(7.9F);
    receipt.setTotal(98.38F);

    String uri = "/receipt";

    MvcResult mvcResult = mvc
      .perform(
        MockMvcRequestBuilders
          .get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)
          .content(jsonInput.toString())
      )
      .andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);

    String response = mvcResult.getResponse().getContentAsString();
    String expected = new JSONObject(receipt).toString();

    JSONAssert.assertEquals(expected, response, false);
  }
}
