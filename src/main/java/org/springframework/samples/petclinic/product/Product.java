package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
	
	@Id
	@NotEmpty
    private Integer id;
    
	@Size(min = 3, max = 50)
	@NotEmpty
	private String name;
	
	@NotEmpty
	@DecimalMin(value = "0.0")
    private double price;
	
	@ManyToOne(optional = false)
    private ProductType productType;
}
