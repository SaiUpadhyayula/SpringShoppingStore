package com.spring.shopping.service;

import java.util.List;

import com.spring.shopping.model.Product;

public interface ProductConfigService {
	List<Product> getFeaturedProducts();

	Product getProductById(Long productId);
}
