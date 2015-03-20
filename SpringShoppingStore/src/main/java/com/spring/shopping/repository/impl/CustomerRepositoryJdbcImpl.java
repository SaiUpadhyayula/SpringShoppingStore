package com.spring.shopping.repository.impl;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.spring.shopping.model.Customer;
import com.spring.shopping.repository.CustomerRepository;
import com.spring.shopping.util.CustomerMapper;

@Repository
public class CustomerRepositoryJdbcImpl implements CustomerRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public Customer validateUsers(String userName, String password) {
		try {
			String sql = "select * from customer c where c.User_Name=:userName and c.Pass=:password";
			SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
					.addValue("userName", userName).addValue("password",
							password);
			Customer customer = namedParameterJdbcTemplate.queryForObject(sql,
					sqlParameterSource, new CustomerMapper());
			return customer;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Integer registerUser(Customer customer) {
		String sql = "INSERT INTO customer (User_Name,Pass,Email_Address) VALUES(:userName,:password,:emailAddress)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				customer);

		return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public boolean changePassword(String password, Customer customer) {
		String sql = "UPDATE customer c SET c.Pass=:password where c.Customer_Id=:customerId";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters)
				.addValue("password", password);
		((MapSqlParameterSource) namedParameters).addValue("customerId",
				customer.getCustomerId());
		int result = namedParameterJdbcTemplate.update(sql, namedParameters);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		String sql = "SELECT * FROM Customer c WHERE c.Customer_Id=:customerId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"customerId", customerId);
		Customer customer = namedParameterJdbcTemplate.queryForObject(sql,
				sqlParameterSource, new CustomerMapper());
		return customer;
	}

	@Override
	public Long getCustomerById(String userName) {
		String sql = "SELECT Customer_Id FROM Customer c WHERE c.User_Name=:userName";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"userName", userName);
		return namedParameterJdbcTemplate.queryForLong(sql, sqlParameterSource);

	}

}
