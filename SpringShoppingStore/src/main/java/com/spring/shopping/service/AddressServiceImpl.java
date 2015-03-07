package com.spring.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.Customer;
import com.spring.shopping.repository.AddressRepository;
import com.spring.shopping.util.Utility;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	public void saveAddress(AddressForm address, Customer customer) {
		Long addressId = Utility.generateAddressNumber(address, customer);
		address.setAddressId(addressId);
		addressRepository.saveAddress(address);
	}

	@Override
	public AddressForm getAddressById(Long addressId) {
		return addressRepository.readAddressById(addressId);
	}

}