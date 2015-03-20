package com.spring.shopping.service;

import com.spring.shopping.model.Customer;

public interface CustomerService {

	public Customer validateUsers(String userName, String password);

	public Integer registerUser(Customer customer);

	public boolean changePassword(String password1, Customer customer);

	public Customer getCustomerById(Long customerId);

	public Long getCustomerId(String userName);

}
