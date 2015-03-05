package com.spring.shopping.service;

import javax.servlet.http.HttpServletRequest;

import com.spring.shopping.model.CreditCardForm;

public interface PaymentService {
	public void payByCreditCard(CreditCardForm creditCardForm);

	public CreditCardForm gatherCardDetails(CreditCardForm creditCardForm,
			HttpServletRequest request);
}
