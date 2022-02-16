package com.assignment.shoppingcart.service;


import java.util.List;
import java.util.Optional;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.model.PurchaseOrder;

public interface CheckoutService {
	public double calculateAmount(List<Product> productlist) throws Exception ;
	
	public double calculateTax(double totalsum);
	
	public boolean confirmOrder(PurchaseOrder po) throws Exception;

	public String generateTxnId() ;
}
