package com.xpeppers.salestaxes;

import static org.assertj.core.api.Assertions.assertThat;

import com.xpeppers.salestaxes.entity.Product;
import com.xpeppers.salestaxes.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void whenFindByName_thenReturnProduct() {
    // given
    Product p = new Product();
    p.setName("phone");
    entityManager.persist(p);
    entityManager.flush();

    // when
    Product found = productRepository.findByName(p.getName());

    // then
    assertThat(found.getName()).isEqualTo(p.getName());
  }
}
