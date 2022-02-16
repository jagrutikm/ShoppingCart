package com.assignment.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class PurchaseOrder {
	@Id	
	private String transactionId;
	@Column(name = "cartId", nullable = false, unique = true)
	private Integer cartId;
	private double orderprice;
	private double taxamount;
	private double totalAmount;
	private double paymentAmount;
	
	
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		
		this.transactionId = transactionId;
	}
	
		
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public double getTaxamount() {
		return taxamount;
	}
	public void setTaxamount(double taxamount) {
		this.taxamount = taxamount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [transactionId=" + transactionId + ", orderprice=" + orderprice + ", taxamount=" + taxamount
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
	
	
}
