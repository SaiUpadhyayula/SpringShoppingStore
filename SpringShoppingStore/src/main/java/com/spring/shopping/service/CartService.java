package com.spring.shopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.controller.constants.ControllerConstants;
import com.spring.shopping.model.Customer;
import com.spring.shopping.model.OrderItem;
import com.spring.shopping.model.Product;

@Service
public class CartService {

	/**
	 * This class is used to handle all the Shopping Cart Operations like
	 * Add,Remove,Update the Items.
	 * 
	 * @author Sai Upadhyayula
	 * 
	 */
	@Autowired
	private ProductConfigService productConfigService;
	@Autowired
	private HttpSession session;

	// Add Products to Shopping Cart
	public synchronized void addProduct(CartData cartData, Long productId) {
		if (cartData.contains(productId)) {
			cartData.incrementProductQuantity(productId);
		} else {
			OrderItem orderItem = cartData.getProduct(productId);
			Product product = productConfigService.getProductById(productId);
			if (orderItem == null) {
				orderItem = new OrderItem();
				orderItem.setProduct(product);
				orderItem.setQuantity(0);
				cartData.add(productId, orderItem);
				orderItem.incrementQuantity();
			}
		}
	}

	public synchronized void updateProduct(CartData cartData, Long productId,
			int quantity) {
		OrderItem orderItem = cartData.getProduct(productId);
		orderItem.setQuantity(quantity);
	}

	public synchronized int getProductsCount(CartData cartData) {
		return cartData.getCartSize();
	}

	public synchronized boolean containsProduct(CartData cartData,
			Long productId) {
		return cartData.containsKey(productId);
	}

	public synchronized void incrementProductQuantity(CartData cartData,
			Long productId) {
		OrderItem orderItem = cartData.getProduct(productId);
		orderItem.incrementQuantity();
	}

	public synchronized void decrementProductQuantity(CartData cartData,
			Long productId) {
		cartData.decrementProductQuantity(productId);
	}

	public synchronized int getNumberOfItems(CartData cartData) {
		return cartData.getNumberOfItems();
	}

	public synchronized void removeProduct(CartData cartData, Long productId) {
		cartData.removeProduct(productId);
	}

	public synchronized void clearCart(CartData cartData) {
		cartData.clearCart();
	}

	public synchronized List<OrderItem> getOrderItemsList(CartData cartData) {
		return cartData.getOrderItemsList();
	}

	public synchronized double getTotal(CartData cartData) {
		return cartData.getTotal();
	}

	public synchronized boolean isCartEmpty(CartData cartData) {
		return cartData.isCartEmpty();
	}

	public CartData getShoppingCart() {
		CartData cartData = (CartData) session
				.getAttribute(ControllerConstants.CART);
		if (cartData != null)
			return cartData;
		else
			return new CartData();
	}

	public CartData getShoppingCartByCustomer(Customer customer) {
		return null;
	}

	public void saveShoppingCartDetails(CartData customerCartData,
			Customer customer) {

	}

	public void saveCartInDatabase(CartData cart, Customer customer) {

	}

}
