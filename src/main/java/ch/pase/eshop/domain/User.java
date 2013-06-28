package ch.pase.eshop.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ch.pase.eshop.domain.core.AbstractEntity;

@Getter
@Setter
@ToString(exclude = "orders")
@Entity
public class User extends AbstractEntity{
	@NotNull private String lastName;
	@NotNull private String firstName;
	@Column(unique = true)
	private EmailAddress emailAddress;
	private String phone;
	private String address;
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Order> orders = new HashSet<Order>();
	
	@NotNull private Role role;
	
	/**
	 * An {@link User} must be assigned at least one of the following {@link Role}.
	 */
	public static enum Role {

		/**
		 * The customer is a registered shop {@link User}
		 */
		CUSTOMER,
		
		/**
		 * The shop owner manages the shop
		 */
		SHOPOWNER,
		

		/**
		 * An adminstrator {@link User} can create a shop with a shop owner
		 */
		ADMINISTRATOR;
	}
}
