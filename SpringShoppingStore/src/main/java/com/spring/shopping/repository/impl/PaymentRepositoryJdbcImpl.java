package com.spring.shopping.repository.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.spring.shopping.model.CreditCardForm;
import com.spring.shopping.repository.PaymentRepository;

@Repository
public class PaymentRepositoryJdbcImpl implements PaymentRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public void payByCreditCard(CreditCardForm creditCardForm) {
		String sql = "insert into payment (CC_Number,CC_Name,CC_CVV,CC_Expiry_Month,CC_Expiry_Year,Customer_Id) values (:creditCardNumber,:name,:cvvCode,:month,:year,:customerId)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				creditCardForm);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}

}
