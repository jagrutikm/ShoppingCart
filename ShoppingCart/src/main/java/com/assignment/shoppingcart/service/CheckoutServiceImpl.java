package com.assignment.shoppingcart.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.shoppingcart.model.Cartitems;
import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.model.PurchaseOrder;
import com.assignment.shoppingcart.repository.ProductRepository;
import com.assignment.shoppingcart.repository.PurchaseOrderRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService{
	@Autowired
	ProductRepository repo;
	
	@Autowired
	PurchaseOrderRepository purchaserepo;
	
	public double calculateAmount(List<Product> productlist ) throws Exception {	
		double totalsum = 0.0;		
		totalsum = productlist.stream().mapToDouble(p -> p.getPrice()*p.getQuantity())
        .reduce(0, (value1, value2) -> value1 + value2);  	 
		return totalsum;
	}
	
	public double calculateTax(double totalsum) {		
		return totalsum*0.05;		 
	}
	
	public boolean confirmOrder(PurchaseOrder po) throws Exception {	
		//In real time there are various processes involved in checkout such as 
		// persist data in purchase_order
		//clear the Cart
		//Persist data in payment tables , generate invoice etc 
		// proceed for shipment 
		// For Assignment purpose kept it simple !!!
		boolean orderConfirmed= false;
		Optional<PurchaseOrder> result = purchaserepo.findBycartId(po.getCartId());
		if(result.isPresent()) { return orderConfirmed;  }		
		purchaserepo.save(po);
		return true;
	}

	public String generateTxnId() {	
		int txnnumber = new Random().nextInt(999999);
		String txnId = String.format("%010d", txnnumber);
		return txnId ;		 
	}
}
