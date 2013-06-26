package ch.pase.eshop.server.dao.init;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import ch.pase.eshop.domain.Product;
import ch.pase.eshop.server.dao.ProductRepository;

/**
 * Initializer to set up {@link Product}s.
 */
public class ProductInitializer {

	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void init() {

		Product milk = new Product();
		milk.setName("milk");
		milk.setQuantity(2);
		milk.setPrice(new BigDecimal(2.5));
		
		Product chocolate = new Product();
		chocolate.setName("chocolate");
		chocolate.setQuantity(3);
		chocolate.setPrice(new BigDecimal(3.5));
		

		productRepository.save(Arrays.asList(milk, chocolate));
	}
}
