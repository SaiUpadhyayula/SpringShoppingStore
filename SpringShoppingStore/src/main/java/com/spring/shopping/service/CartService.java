package com.spring.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private int numberOfItems;
	@Autowired
	private ProductConfigService productConfigService;

	public CartService() {
		productsMap = new ConcurrentHashMap<Long, OrderItem>();
	}

	// Add Products to Shopping Cart
	public void addProduct(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		Product product = productConfigService.getProductById(productId);
		if (orderItem == null) {
			orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(0);
			productsMap.put(productId, orderItem);
		}
		orderItem.incrementQuantity();
	}
	public void updateProduct(Long productId, int quantity) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.setQuantity(quantity);
	}

	public Map<Long, OrderItem> getProductsList() {
		return productsMap;
	}

	public int getProductsCount() {
		return productsMap.size();
	}

	public boolean containsProduct(Long productId) {
		return productsMap.containsKey(productId);
	}

	public void incrementProductQuantity(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.incrementQuantity();
	}

	public void decrementProductQuantity(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.decrementQuantity();
	}

	public int getNumberOfItems() {
		numberOfItems = 0;
		List<OrderItem> itemsList = new ArrayList<OrderItem>();
		itemsList.addAll(productsMap.values());
		for (OrderItem item : itemsList) {
			numberOfItems += item.getQuantity();
		}

		return numberOfItems;
	}

	public void removeProduct(Long productId) {
		decrementProductQuantity(productId);
		productsMap.remove(productId);
	}

	public void clearCart() {
		productsMap.clear();
		numberOfItems = 0;
	}

	public double getTotal() {
		double amount = 0.0;
		Map<Long, OrderItem> cartProducts = getProductsList();
		for (OrderItem item : cartProducts.values()) {
			amount = amount + (item.getTotal()).doubleValue();
		}
		return amount;
	}
}
