package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "productstype")
public class ProductType {
	
	@Id
	@NotEmpty
    private Integer id;
	
	@Size(min = 3, max = 50)
	@NotEmpty
	@UniqueElements
    private String name;
}
