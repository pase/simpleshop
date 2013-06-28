package ch.pase.eshop.server.dao.init;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import ch.pase.eshop.domain.Product;
import ch.pase.eshop.server.dao.ProductRepository;

/**
 * Initializer to set up the database data.
 */
public class DataInitializer {

	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void init() {

		Product milk = new Product("milk", new BigDecimal(2.5), 2);
		Product chocolate = new Product("chocolate", new BigDecimal(3.5), 3);
		
		productRepository.save(Arrays.asList(milk, chocolate));
	}
}
