package com.xpeppers.salestaxes;




import java.util.ArrayList;
import java.util.List;

import com.xpeppers.salestaxes.controller.ControllerRest;
import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.entity.Receipt;
import com.xpeppers.salestaxes.service.ReceiptService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ControllerRest.class)

public class ControllerRestTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
    private ReceiptService receiptService;

	

	//String exampleProductJson = "{products:[{name: 'choccolate',price: '11.25',quantity: 3,taxed: false,imported:true},{name: 'perfume',price: 27.99,quantity: 1,taxed: true,imported:true},{name: 'perfume',price: 18.99,quantity: 1,taxed: true, imported:false},{name: 'headache',price: 9.75,quantity: 1,taxed: false,imported:false}]}";


	@Test
	public void retrieveDetailsForCourse() throws Exception {

		/*INPUT*/
		Product p1=new Product("book", 12.49F, 2, false, false);
		Product p2=new Product("music CD", 14.99F, 1, true, false);
        Product p3=new Product("choccolate bar", 0.85F, 1, false, false);
		
        List<Product> products=new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		JSONArray jsonArrayInput = new JSONArray(products);
		JSONObject jsonInput =new JSONObject();
		jsonInput.put("products",jsonArrayInput);


		/*EXPETED OUTPUT*/
		Receipt receipt= new Receipt();
		p1.setPrice(24.98F);
		p2.setPrice(16.49F);
		p3.setPrice(0.85F);
		receipt.setProducts(products);
		receipt.setTaxes(1.5F);
		receipt.setTotal(42.32F);
		
		
		
        
		System.out.println("Input: "+jsonInput.toString());
		

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/receipt").accept(
                MediaType.APPLICATION_JSON).content(jsonInput.toString()).contentType(MediaType.APPLICATION_JSON);


		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("RESPONSE: "+result.getResponse().getContentAsString());
		
		String expected = new JSONObject(receipt).toString();

		System.out.println("EXPETED: "+new JSONObject(receipt).toString());
		
		

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}