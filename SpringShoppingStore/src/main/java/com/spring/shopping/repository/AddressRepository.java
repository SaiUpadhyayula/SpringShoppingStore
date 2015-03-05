package com.spring.shopping.repository;

import com.spring.shopping.model.AddressForm;

public interface AddressRepository {

	public void saveAddress(AddressForm address);

	public AddressForm readAddressById(Long addressId);
}
