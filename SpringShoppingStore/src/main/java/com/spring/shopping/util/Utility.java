package com.spring.shopping.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.Customer;

public class Utility {

	public static Long generateOrderNumber(Date date, Customer customer) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String formattedDate = dateFormat.format(date);
		Long orderId = Long.parseLong(formattedDate)
				* (customer.getCustomerId());
		return orderId;
	}

	public static Long generateAddressNumber(AddressForm address,
			Customer customer) {
		return (long) (Long.parseLong(address.getZipCode())
				* customer.getCustomerId() * Math.random());
	}
}