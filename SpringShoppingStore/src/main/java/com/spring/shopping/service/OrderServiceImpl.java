package com.spring.shopping.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.controller.constants.ControllerConstants;
import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Order;
import com.spring.shopping.model.OrderItem;
import com.spring.shopping.model.Product;
import com.spring.shopping.repository.OrderRepository;
import com.spring.shopping.util.SessionUtils;
import com.spring.shopping.util.Utility;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	private final String PENDING_ORDER_STATUS = "Pending";

	// private final String COMPLETED_ORDER_STATUS = "Completed";

	@Override
	public Order createOrder(CartService cartService,
			Customer customer, AddressForm address, HttpServletRequest request)
			throws ParseException {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(date);
		Date presentDate = dateFormat.parse(formattedDate);
		java.util.Date sqlDate = new java.util.Date(presentDate.getTime());
		Long orderId = Utility.generateOrderNumber(date, customer);
		Order order = new Order();
		order.setOrderId(orderId);
		order.setCreatedDate(sqlDate);
		order.setUpdatedDate(sqlDate);
		order.setEmailAddress(customer.getEmailAddress());
		order.setOrderStatus(PENDING_ORDER_STATUS);
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		order.setOrderTotal(new BigDecimal(cartService.getTotal(cartData)));
		order.setCustomerId(customer.getCustomerId());
		List<OrderItem> orderItemsList = new ArrayList<OrderItem>();
		for (OrderItem orderItem : cartService.getOrderItemsList(cartData)) {
			orderItemsList.add(orderItem);
		}
		orderRepository.createOrder(order, orderItemsList, address);
		return order;
	}

	@Override
	public List<Product> getAllOrderItems(Order order) {

		return orderRepository.readAllOrderItems(order);
	}

	@Override
	public List<Order> getAllOrdersForCustomer(Customer customer) {

		return orderRepository.readAllOrdersForCustomer(customer);
	}

	@Override
	public Order getOrderById(Long orderId) {
		return orderRepository.readOrderById(orderId);
	}

}