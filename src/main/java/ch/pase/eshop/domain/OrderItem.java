package ch.pase.eshop.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.springframework.util.Assert;

import ch.pase.eshop.domain.core.AbstractEntity;

@Entity
@Getter
@Setter
public class OrderItem extends AbstractEntity{
	@NotNull private int amount;
	@NotNull private BigDecimal purchasePrice;
	
	@OneToOne()
	@NotNull private Product product;
	
	/**
	 * Creates a new {@link OrderItem} for the given {@link Product} and amount = 1.
	 * 
	 * @param product must not be {@literal null}.
	 */
	public OrderItem(Product product) {
		this(product, 1);
	}

	/**
	 * Creates a new {@link OrderItem} for the given {@link Product} and amount.
	 * 
	 * @param product must not be {@literal null}.
	 * @param amount must be greater than 0
	 */
	public OrderItem(Product product, int amount) {

		Assert.notNull(product, "The given Product must not be null!");
		Assert.isTrue(amount > 0, "The amount of Products to be bought must be greater than 0!");

		this.product = product;
		this.amount = amount;
		this.purchasePrice = product.getPrice();
	}

	protected OrderItem() {}
	
	/**
	 * @return the the total for the {@link OrderItem}.
	 */
	public BigDecimal getTotal() {
		return purchasePrice.multiply(BigDecimal.valueOf(amount));
	}
}
