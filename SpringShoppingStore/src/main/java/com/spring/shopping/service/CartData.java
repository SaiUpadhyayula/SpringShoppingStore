package com.spring.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.spring.shopping.model.OrderItem;

public class CartData {
	private Map<Long, OrderItem> productsMap;
	private int numberOfItems;

	public CartData() {
		productsMap = new ConcurrentHashMap<Long, OrderItem>();
	}

	public void add(Long productId, OrderItem orderItem) {
		productsMap.put(productId, orderItem);
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

	public boolean contains(Long productId) {
		return productsMap.containsKey(productId);
	}

	public void incrementProductQuantity(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.incrementQuantity();
	}

	public void clearCart() {
		productsMap.clear();
		numberOfItems = 0;
	}

	public void decrementProductQuantity(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.decrementQuantity();
	}

	public void removeProduct(Long productId) {
		decrementProductQuantity(productId);
		productsMap.remove(productId);
	}

	public Map<Long, OrderItem> getProductsList() {
		return productsMap;
	}

	public double getTotal() {
		double amount = 0.0;
		for (OrderItem item : productsMap.values()) {
			amount = amount + (item.getTotal()).doubleValue();
		}
		return amount;
	}

	public boolean isCartEmpty() {
		return productsMap.isEmpty();
	}
}
