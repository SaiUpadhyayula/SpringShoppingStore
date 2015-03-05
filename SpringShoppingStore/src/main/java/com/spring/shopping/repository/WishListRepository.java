package com.spring.shopping.repository;

import java.util.List;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Product;

public interface WishListRepository {

	boolean addProductToWishList(Product product,Customer customer);

	List<Product> readProductsInWishList(Customer customer);

	boolean checkIfProductAvailableInWishList(Product product);
	
	void deleteProductFromWishList(Product product);
}
