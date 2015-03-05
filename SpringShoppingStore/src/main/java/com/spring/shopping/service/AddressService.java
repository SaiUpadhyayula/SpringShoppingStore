package com.spring.shopping.service;

import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.Customer;

public interface AddressService {
	public void saveAddress(AddressForm address,Customer customer);
	AddressForm getAddressById(Long addressId);
}
