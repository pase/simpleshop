package ch.pase.eshop.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.joda.time.DateTime;
import org.springframework.util.Assert;

import ch.pase.eshop.domain.core.AbstractEntity;


@Getter
@Setter
@ToString(exclude = "orderItems")
@Entity
@Table(name = "ShopOrder") //Order is an SQL keyword
public class Order extends AbstractEntity {
	
	@NotNull private DateTime orderedDate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	@ManyToOne
	@NotNull private User customer;
	
	@ManyToOne
	@NotNull private Shop shop;
	
	/**
	 * Creates a new {@link Order} for the given customer and {@link Shop}.
	 * 
	 * @param customer must not be {@literal null}.
	 * @param shop must not be {@literal null}.
	 */
	public Order(User customer, Shop shop) {

		Assert.notNull(customer);
		Assert.notNull(shop);

		this.customer = customer;
		this.shop = shop;
	}
	
	protected Order() {}
	
	/**
	 * Returns the price of the {@link Order} calculated from the contained {@link OrderItem}.
	 * 
	 * @return will never be {@literal null}.
	 */
	public BigDecimal getPrice() {

		BigDecimal result =  BigDecimal.ZERO;

		for (OrderItem orderItem : orderItems) {
			result = result.add(orderItem.getTotal());
		}

		return result;
	}
	
	/**
	 * An {@link Order} can be in one of the following state.
	 */
	public static enum Status {

		/**
		 * The order is placed, but is still changeable: the customer can cancel the Order,
		 * the shop owner can change the quantity
		 */
		NEW,

		/**
		 * {@link Order} was confirmed by the shop owner. No changes allowed to it anymore.
		 */
		CONFIRMED,
		
		/**
		 * {@link Order} was cancelled by the customer or the shop owner. No changes allowed to it anymore.
		 */
		CANCELLED,

		/**
		 * The {@link Order} is ready to be picked up by the customer.
		 */
		READY,

		/**
		 * The {@link Order} was completed.
		 */
		COMPLETED;
	}
}
