package com.spring.shopping.repository.impl;

import java.util.List;

import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Order;
import com.spring.shopping.model.OrderItem;
import com.spring.shopping.model.Product;
import com.spring.shopping.repository.OrderRepository;

public class OrderRepositoryHibernateImpl implements OrderRepository {

	@Override
	public void createOrder(Order order, List<OrderItem> orderItemsList,
			AddressForm address) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> readAllOrderItems(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> readAllOrdersForCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order readOrderById(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
