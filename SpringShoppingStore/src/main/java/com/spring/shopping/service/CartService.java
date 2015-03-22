package com.spring.shopping.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	// Map to store ProductId and Integer
	private Map<Long, OrderItem> productsMap;
	@Autowired
	private ProductConfigService productConfigService;
	@Autowired
	private CartData cartData;

	// Add Products to Shopping Cart
	public synchronized void addProduct(Long productId) {
		if (!cartData.contains(productId)) {
			cartData.incrementProductQuantity(productId);
		} else {
			OrderItem orderItem = productsMap.get(productId);
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

	public synchronized void updateProduct(Long productId, int quantity) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.setQuantity(quantity);
	}

	public synchronized int getProductsCount() {
		return productsMap.size();
	}

	public synchronized boolean containsProduct(Long productId) {
		return productsMap.containsKey(productId);
	}

	public synchronized void incrementProductQuantity(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.incrementQuantity();
	}

	public synchronized void decrementProductQuantity(Long productId) {
		cartData.decrementProductQuantity(productId);
	}

	public synchronized int getNumberOfItems() {
		return cartData.getNumberOfItems();
	}

	public synchronized void removeProduct(Long productId) {
		cartData.removeProduct(productId);
	}

	public synchronized void clearCart() {
		cartData.clearCart();
	}

	public synchronized Map<Long, OrderItem> getProductsList() {
		return cartData.getProductsList();
	}

	public synchronized double getTotal() {
		return cartData.getTotal();
	}

	public synchronized boolean isCartEmpty() {
		return cartData.isCartEmpty();
	}

	public CartData getShoppingCart() {
		return cartData;
	}

	public void setShoppingCart(CartData cartData) {
		this.cartData = cartData;
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
