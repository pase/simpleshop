package ch.pase.eshop.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import org.springframework.util.Assert;

import ch.pase.eshop.domain.core.AbstractEntity;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Product extends AbstractEntity {
	@NotNull @NonNull private String name;
	private String description;
	private byte[] image;
	@NotNull @NonNull private int stockQuantity;
	@NotNull @NonNull private BigDecimal price;
	private boolean active;
	private int sortOrder;
	
	/**
	 * Creates a new {@link Product} from the given parameters.
	 * 
	 * @param name must not be {@literal null} or empty.
	 * @param price must not be {@literal null} or less than or equal to zero.
	 * @param stockQuantity must be greater than 0.
	 */
	public Product(String name, BigDecimal price, int stockQuantity) {
		this(name, price, stockQuantity, null);
	}

	/**
	 * Creates a new {@link Product} from the given parameters.
	 * 
	 * @param name must not be {@literal null} or empty.
	 * @param price must not be {@literal null} or less than or equal to zero.
	 * @param stockQuantity must be greater than 0.
	 * @param description
	 */
	public Product(String name, BigDecimal price, int stockQuantity, String description) {

		Assert.hasText(name, "Name must not be null or empty!");
		Assert.isTrue(BigDecimal.ZERO.compareTo(price) < 0, "Price must be greater than zero!");
		Assert.isTrue(stockQuantity > 0, "The number of Products must be greater than 0!");

		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.description = description;
	}

	protected Product() {}
	
}
