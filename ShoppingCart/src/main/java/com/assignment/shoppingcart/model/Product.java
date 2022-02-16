package com.assignment.shoppingcart.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.sun.istack.NotNull;

@Entity
@Table(name="productorders")
public class Product implements Serializable{

	@Id	
	private Integer productid;
	//@GeneratedValue 
	@NotBlank(message = "name is required")
	private String name;
    @NotBlank(message = "description is required")
	private String description;
    @NotNull
	private double price;	
    @Column(name = "quantity", nullable = false)
	private Integer quantity;
	//private Date deliveryDate;
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})	
	@JoinColumn(name="cart_id") 
	private Cartitems cartitems;
	
	 	 
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}		
		
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Cartitems getCartitems() {
		return cartitems;
	}
	public void setCartitems(Cartitems cartitems) {
		this.cartitems = cartitems;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + ", cartitems=" + cartitems + "]";
	}
	 
	 	 
	
	
}
