package com.spring.shopping.repository;

import java.util.List;

import com.spring.shopping.model.Product;

public interface ProductConfigRepository {

	List<Product> readFeaturedProducts();

	Product readProductById(Long productId);

}
