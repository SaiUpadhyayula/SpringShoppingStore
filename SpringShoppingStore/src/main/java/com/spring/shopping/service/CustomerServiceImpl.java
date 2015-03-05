package com.spring.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.model.Customer;
import com.spring.shopping.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer validateUsers(String userName, String password) {
		Customer customer = customerRepository
				.validateUsers(userName, password);
		return customer;
	}

	@Override
	public Integer registerUser(Customer customer) {

		return customerRepository.registerUser(customer);
	}

}
