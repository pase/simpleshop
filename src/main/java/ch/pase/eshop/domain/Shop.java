package ch.pase.eshop.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.util.Assert;

import ch.pase.eshop.domain.core.AbstractEntity;

@Getter
@Setter
@ToString(exclude = {"owner", "products"})
@Entity
public class Shop extends AbstractEntity {
	
	@NotNull private String name;
	private String tagLine;
	private String description;
	private byte[] icon;
	private byte[] image;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> products = new HashSet<Product>();
	@ManyToOne
	@NotNull private User owner;
	
	/**
	 * Creates a new {@link Shop} for the given owner and name.
	 * 
	 * @param owner must not be {@literal null}.
	 * @param name must not be {@literal null}.
	 */
	public Shop(User owner, String name) {

		Assert.notNull(owner);
		Assert.hasText(name, "Name must not be null or empty!");

		this.owner = owner;
		this.name = name;
	}
	
	protected Shop() {}
	
}
