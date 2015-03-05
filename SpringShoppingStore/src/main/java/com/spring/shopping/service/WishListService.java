package com.spring.shopping.service;

import java.util.List;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Product;

public interface WishListService {
    boolean addProductToWishList(Long productId,Customer customer);

	List<Product> getProductsInWishList(Customer customer);
	
	boolean checkIfProductAvailableInWishList(Long productId);
	
	void deleteProductFromWishList(Long productId);
}
