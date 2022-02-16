package com.assignment.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.shoppingcart.model.Product;


public interface CartService  {
	
	public Product addUpdateProduct(Product product) ;	
	
	public Product updateCart(Product product) ;		
	
	public Optional<List<Product>> fetchCartById(int cartId) ;
			
	public String deleteProduct(int productid) ;
		
	public List<Product> fetchCart() ;
		
	
}
