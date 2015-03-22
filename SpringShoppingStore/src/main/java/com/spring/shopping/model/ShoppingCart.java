package com.spring.shopping.model;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCart {
	
	private Long shoppingCart_Id;
	private Date createdDate;
	private Date modifiedDate;
	private BigDecimal cartTotal;
	private Integer cartSize;
	private Customer customer;

	public Long getShoppingCart_Id() {
		return shoppingCart_Id;
	}

	public void setShoppingCart_Id(Long shoppingCart_Id) {
		this.shoppingCart_Id = shoppingCart_Id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public BigDecimal getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(BigDecimal cartTotal) {
		this.cartTotal = cartTotal;
	}

	public Integer getCartSize() {
		return cartSize;
	}

	public void setCartSize(Integer cartSize) {
		this.cartSize = cartSize;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
