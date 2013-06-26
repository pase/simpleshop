package ch.pase.eshop.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ch.pase.eshop.domain.core.AbstractEntity;

@Getter
@Setter
@ToString(callSuper = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbstractEntity {
	@NotNull @NonNull private String name;
	private String description;
	private byte[] image;
	@NotNull @NonNull private int quantity;
	@NotNull @NonNull private BigDecimal price;
	private boolean active;
	private int sortOrder;
	
}
