package com.spring.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.model.Product;
import com.spring.shopping.repository.ProductConfigRepository;

@Service
public class ProductConfigServiceImpl implements ProductConfigService {

	@Autowired
	private ProductConfigRepository productConfigRepository;

	public List<Product> getFeaturedProducts() {
		List<Product> featuredProdList = productConfigRepository
				.readFeaturedProducts();
		return featuredProdList;
	}

	@Override
	public Product getProductById(Long productId) {
		Product product = productConfigRepository.readProductById(productId);
		return product;
	}

}
