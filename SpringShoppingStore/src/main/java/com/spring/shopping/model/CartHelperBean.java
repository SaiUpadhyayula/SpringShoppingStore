package com.spring.shopping.model;

import java.io.Serializable;

import com.spring.shopping.service.CartData;

public class CartHelperBean implements Serializable{
	

	private static final long serialVersionUID = 868790187622618890L;
	private String customerIdentity;
	private CartData cartData;
	
	public Object getCustomerIdentity() {
		return customerIdentity;
	}

	public void setCustomerIdentity(String customerIdentity) {
		this.customerIdentity = customerIdentity;
	}

	public CartData getCartData() {
		return cartData;
	}

	public void setCartData(CartData cartData) {
		this.cartData = cartData;
	}


}
