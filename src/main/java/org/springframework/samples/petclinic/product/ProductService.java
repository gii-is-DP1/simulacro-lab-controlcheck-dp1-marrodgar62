package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productoRepo;
	
    public List<Product> getAllProducts(){
        return productoRepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return null;
    }

    public ProductType getProductType(String typeName) {
        return productoRepo.findByName(typeName).getProductType();
    }

    public Product save(Product p){
        return productoRepo.save(p);       
    }

    public List<ProductType> findAllProductTypes() {
    	return productoRepo.findAllProductTypes();
    }
}
