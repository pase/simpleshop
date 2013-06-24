package ch.eshop.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import ch.eshop.domain.core.AbstractEntity;

@Entity
@Getter
@Setter
public class OrderItem extends AbstractEntity{
	private int quantity;
	@NotNull private String productName;
	@NotNull private BigDecimal price;
}
