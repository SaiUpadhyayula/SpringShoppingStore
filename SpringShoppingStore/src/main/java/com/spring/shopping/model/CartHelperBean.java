package com.spring.shopping.model;

import com.spring.shopping.service.CartData;

public class CartHelperBean {
	
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
