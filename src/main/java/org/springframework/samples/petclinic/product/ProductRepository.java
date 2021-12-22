package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
	
    List<Product> findAll();
    
    @Query(nativeQuery = true, value = "SELECT pt.* FROM productstype pt JOIN product p WHERE pt.id = p.product_type_id")
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    
    Product findByName(String name);
    
    Product save(Product p);
}
