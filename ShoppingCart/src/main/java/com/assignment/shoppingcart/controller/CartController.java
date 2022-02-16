package com.assignment.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.shoppingcart.exception.CartNotFoundException;
import com.assignment.shoppingcart.exception.DuplicatePurchaseException;
import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.model.PurchaseOrder;
import com.assignment.shoppingcart.service.CartService;
import com.assignment.shoppingcart.service.CheckoutService;


@RestController
@Validated
public class CartController {
			
	@Autowired
	CartService cartservice;
	
	@Autowired
	CheckoutService checkoutservice;
	
	
	Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@GetMapping("/")
	public List<Product> getCarts(){		
		List<Product> products = cartservice.fetchCart();		
		return products;
	}
	
	
	@PostMapping("/addProduct") 
	public ResponseEntity<?> addToCart(@Valid @RequestBody Product product) {	
		logger.info(" *** Add product to cart ***");
		cartservice.addUpdateProduct(product);		
		logger.info(" *** Add product to cart ends *** ");
		return new ResponseEntity<String>("Product added to cart",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{productid}")
	public ResponseEntity<?> removeFromCart(@PathVariable int productid ) {	
		logger.info(" *** Remove product from cart ***");
		cartservice.deleteProduct(productid);
		logger.info(" *** Remove product from cart ends ***");
		return new ResponseEntity<String>("Removed product from cart",HttpStatus.OK);
		
	}
	
	@PutMapping("/updateCart")
	public Product updateCart(@RequestBody Product cartitems) {	
		logger.info(" *** Update cart ***");
		cartservice.updateCart(cartitems);	
		logger.info(" *** Update cart ends *** ");
		return cartitems;
	}
	
	@GetMapping("/fetchCart")
	public List<Product> getCart(){
		logger.info(" *** Fetch cart  *** ");
		List<Product> products = new ArrayList<>();
		logger.info(" *** Fetch cart ends *** ");
		return products;
	}
		
	
	@GetMapping("/fetchCartById/{cartId}")
	public ResponseEntity<?> getCartById(@PathVariable int cartId) {		
		Optional<List<Product>> products = cartservice.fetchCartById(cartId);	
		logger.info(" *** Fetch cart by Id  products *** "+products);
					
		if(products.isPresent() && products.get().size()>0) 
			return new ResponseEntity<List<Product>>(products.orElseThrow(),HttpStatus.OK);	
			
		else 
			//throw new CartNotFoundException();			
			return new ResponseEntity<String>("Cart details not found !!",HttpStatus.OK);	 
	}
	
		
	@PostMapping("/placeOrder")
	public ResponseEntity<?> purchaseOrder(@RequestBody PurchaseOrder purchaseorder) throws Exception {
		logger.info(" *** Checkout Process-Place order   *** ");	
		Optional<List<Product>> productlist = cartservice.fetchCartById(purchaseorder.getCartId());	
		if(!productlist.isPresent()) {
			throw new CartNotFoundException();
		}
		double totalsum =	checkoutservice.calculateAmount(productlist.get());
		// calculate tax say 5% tax on total amount		
		purchaseorder.setTotalAmount(totalsum);
		purchaseorder.setTaxamount(checkoutservice.calculateTax(totalsum));		
		purchaseorder.setTransactionId(checkoutservice.generateTxnId());
		if (!checkoutservice.confirmOrder(purchaseorder)) {			
			//return new ResponseEntity<String>("Order already confirmed !!",HttpStatus.OK);
			throw new DuplicatePurchaseException();
			
		} else {
			return new ResponseEntity<String>("You Order is Confirmed!! Happy Shopping !!",HttpStatus.OK);
		}
	}
	
}
