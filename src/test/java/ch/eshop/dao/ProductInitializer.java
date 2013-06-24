package ch.eshop.dao;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import ch.pase.eshop.dao.ProductRepository;
import ch.pase.eshop.domain.Product;

/**
 * Initializer to set up {@link Order}s.
 */
@Service
public class ProductInitializer {

	@Autowired
	public ProductInitializer(ProductRepository productRepository) {

		Assert.notNull(productRepository, "ProductInitializer must not be null!");

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
