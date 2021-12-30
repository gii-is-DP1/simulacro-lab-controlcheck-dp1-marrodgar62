package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/product")
public class ProductController {
    
	private static final String PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	private static final String LISTING = "welcome";

	
	@Autowired
	ProductService service;
	
	@ModelAttribute("productType")
    public Collection<ProductType> populateProductTypes(){
    	return this.service.findAllProductTypes();
    }

	@GetMapping("/create")
	public String create(ModelMap map) {
		Product product = new Product();
		map.addAttribute("product", product);
		return PRODUCTS_CREATE_OR_UPDATE_FORM;
		
	}
	
	@PostMapping("/create")
	public String newCreate(@Valid Product product, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return PRODUCTS_CREATE_OR_UPDATE_FORM;
		} else {
			service.save(product);
			return LISTING;
		}
	}

}
