package com.spring.shopping.repository;

import com.spring.shopping.model.CreditCardForm;

public interface PaymentRepository {
	void payByCreditCard(CreditCardForm creditCardForm);
}
