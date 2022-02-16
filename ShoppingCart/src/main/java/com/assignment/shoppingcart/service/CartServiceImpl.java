package com.assignment.shoppingcart.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired	
	ProductRepository repo;
			
	public Product addUpdateProduct(Product product) {	
		repo.save(product);	 		
		return product;
	}
	
	public Product updateCart(Product product) {	
		Optional<Product> resultOptional = repo.findById(product.getProductid());	    
	    resultOptional.ifPresent((Product result) -> {
	    		result.setQuantity(product.getQuantity()) ;        
	    		repo.save(result);
	    });   	 	
	    return product;
	}
	
	public Optional<List<Product>> fetchCartById(int cartId) {		
		return repo.findByCartitemsId(cartId);
		 
	}
				
	public String deleteProduct(int productid) {			
		repo.deleteById(productid);
		return "Removed product from cart";
	}
		
		
	public List<Product> fetchCart() {
		return repo.findAll();		 
	}
	
	
}
