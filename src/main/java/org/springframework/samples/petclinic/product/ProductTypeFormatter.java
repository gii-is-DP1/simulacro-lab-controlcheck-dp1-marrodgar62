package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	@Autowired
	ProductService service;
	
    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        Collection<ProductType> listProductType = this.service.findAllProductTypes();
    	for(ProductType p : listProductType) {
    		if(p.getName().equals(text)) {
    			return p;
    		}
    	}
    	throw new ParseException("Type not found: " + text, 0);
    }
    
}
