package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productoRepo;
	
    public List<Product> getAllProducts(){
        return productoRepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productoRepo.findByPriceLessThan(price);
    }

    @Transactional
    //@ModelAttribute("productType")
    public ProductType getProductType(String typeName) {
        return productoRepo.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return productoRepo.save(p);       
    }

    @Transactional
    public List<ProductType> findAllProductTypes() {
    	return productoRepo.findAllProductTypes();
    }
}
