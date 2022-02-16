package com.assignment.shoppingcart.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.shoppingcart.model.Product;


public interface ProductRepository extends JpaRepository<Product,Integer>{
	public Product findById(int id);
	 Optional<List<Product>>  findByCartitemsId(int cartid);
	 
}
