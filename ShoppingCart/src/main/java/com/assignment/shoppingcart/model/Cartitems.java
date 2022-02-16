package com.assignment.shoppingcart.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name="cartitems")
public class Cartitems {
	
	@Id
	@NotNull
	//@GeneratedValue
	private Integer id;
	private String User = "TestUser";
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn  = new Date();
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cartitems",fetch = FetchType.LAZY)	
	private List<Product> product;

	 	
	
	public Cartitems() {
		
	}
	
	public Cartitems(Integer cartId, Integer productId, Integer quantity, List<Product> product) {
		
		this.id = cartId;
		this.product = product;
	}

  	

	public Integer getId() {
		return id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	  	 
	public String getUser() {
		return User;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	 

	 

	
	
	
	
}
