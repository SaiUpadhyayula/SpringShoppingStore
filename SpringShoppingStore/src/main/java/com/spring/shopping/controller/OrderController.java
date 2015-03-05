package com.spring.shopping.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.CreditCardForm;
import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Order;
import com.spring.shopping.model.Product;
import com.spring.shopping.service.CartService;
import com.spring.shopping.service.OrderService;
import com.spring.shopping.service.PaymentService;
import com.spring.shopping.service.ProductConfigService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductConfigService productConfigService;
	private HttpSession session;

	@RequestMapping(value = "/createOrderByCC", method = RequestMethod.POST)
	public String createOrder(Model model,
			@ModelAttribute("paymentForm") CreditCardForm creditCardForm,
			HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("order") Order order) throws ParseException,
			IOException {

		session = request.getSession();
		// Retrieve Details about the Cart,Customer and Address Details
		// used to create detailed Order
		CartService cartService = (CartService) session.getAttribute("cart");
		Customer customer = (Customer) session.getAttribute("customer");
		AddressForm address = (AddressForm) session.getAttribute("address");

		orderService.createOrder(order, cartService, customer, address);
		payAmountByCreditCard(creditCardForm, request);
		session.setAttribute("orderDetails", order);
		return "redirect:order";
	}

	public void payAmountByCreditCard(CreditCardForm creditCardForm,
			HttpServletRequest request) throws IOException {

		creditCardForm = paymentService.gatherCardDetails(creditCardForm,
				request);
		paymentService.payByCreditCard(creditCardForm);
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrderConfirmPage(Model model, HttpServletRequest request) {
		Order order = (Order) session.getAttribute("orderDetails");
		model.addAttribute("orderDetails", order);
		List<Product> productsList = orderService.getAllOrderItems(order);
		model.addAttribute("prodList", productsList);
		cartService.clearCart();
		return "order";
	}
}
