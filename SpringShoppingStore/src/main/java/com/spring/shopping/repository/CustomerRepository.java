package com.spring.shopping.repository;

import com.spring.shopping.model.Customer;

public interface CustomerRepository {

	public Customer validateUsers(String userName, String password);

	public Integer registerUser(Customer customer);
	
	public boolean changePassword(String password,Customer customer);

	public Customer getCustomerById(Long customerId);

	Long getCustomerById(String userName);
}
