package com.spring.shopping.repository;

import java.util.List;

import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Order;
import com.spring.shopping.model.OrderItem;
import com.spring.shopping.model.Product;

public interface OrderRepository {
	void createOrder(Order order, List<OrderItem> orderItemsList,AddressForm address);

	List<Product> readAllOrderItems(Order order);

	List<Order> readAllOrdersForCustomer(Customer customer);

	Order readOrderById(Long orderId);
}
