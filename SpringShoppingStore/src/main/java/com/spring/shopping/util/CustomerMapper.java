package com.spring.shopping.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.shopping.model.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerId(rs.getLong("Customer_Id"));
		customer.setFirstName(rs.getString("First_Name"));
		customer.setLastName(rs.getString("Last_Name"));
		customer.setUserName(rs.getString("User_Name"));
		customer.setPassword(rs.getString("Pass"));
		customer.setEmailAddress(rs.getString("Email_Address"));
		customer.setPhoneNumber(rs.getString("Phone_Number"));

		return customer;
	}

}
