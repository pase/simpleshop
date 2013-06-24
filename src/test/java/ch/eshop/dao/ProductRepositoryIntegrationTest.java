package ch.eshop.dao;

import static org.testng.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ch.pase.eshop.ApplicationConfig;
import ch.pase.eshop.dao.ProductRepository;
import ch.pase.eshop.domain.Product;

@ContextConfiguration(classes = ApplicationConfig.class)
@Transactional
@Slf4j
public class ProductRepositoryIntegrationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ProductRepository repository;
	
	private Product saved;
	
	@Test
	public void shouldFindAllProducts() {
		List<Product> products = repository.findAll();
		assertNotNull(products);
		for (Product product : products) {
			log.info(product.toString());
		}
	}
	
	@BeforeClass
	public void shouldCreateProduct() {
		Product apple = new Product("apple", 4, new BigDecimal(1.2));
		saved = repository.save(apple);
		assertNotNull(saved.getId());
	}
	
	@AfterClass
	public void shouldDeleteProduct() {
		repository.delete(saved.getId());
		Assert.assertNull(repository.findOne(saved.getId()));
	}
	
	@Test
	public void shouldFindProduct() {
		Product apple = repository.findOne(saved.getId());
		assertNotNull(apple);
	}
	
	@Test
	public void shouldUpdateProduct() {
		saved.setDescription("an apple a day keeps the doctor away");
		Product apple = repository.save(saved);
		assertNotNull(apple);
	}

}
