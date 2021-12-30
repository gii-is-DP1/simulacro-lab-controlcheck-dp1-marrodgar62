package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
	
    List<Product> findAll();
    
   
    @Query("SELECT ptype FROM ProductType ptype")
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    
    
    Product save(Product p);
    
    @Query(nativeQuery = true, value = "SELECT p.* FROM product p WHERE p.price < ?1")
    List<Product> findByPriceLessThan(double price);
    
    Product findByName(String name);
    
    
    @Query("SELECT ptype FROM ProductType ptype WHERE ptype.name = ?1")
    ProductType findProductTypeByName(String name);

    
}
