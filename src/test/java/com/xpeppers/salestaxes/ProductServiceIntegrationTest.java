package com.xpeppers.salestaxes;

import static org.assertj.core.api.Assertions.assertThat;

import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.repository.ProductRepository;
import com.xpeppers.salestaxes.service.ProductService;
import com.xpeppers.salestaxes.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProductServiceIntegrationTest {

  @TestConfiguration
  static class ProductServiceImplTestContextConfiguration {

    @Bean
    public ProductService productService() {
      return new ProductServiceImpl();
    }
  }

  @Autowired
  private ProductService productService;

  @MockBean
  private ProductRepository productRepository;

  @Before
  public void setUp() {
    Product p = new Product();
    p.setName("phone");

    Mockito.when(productRepository.findByName(p.getName())).thenReturn(p);
  }

  @Test
  public void whenValidName_thenProductShouldBeFound() {
    String name = "phone";
    Product found = productService.getProductByName(name);

    assertThat(found.getName()).isEqualTo(name);
  }
}
