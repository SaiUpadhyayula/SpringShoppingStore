package com.spring.shopping.repository.impl;

import java.util.List;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Product;
import com.spring.shopping.repository.WishListRepository;

public class WishListRepositoryHibernateImpl implements WishListRepository {

	@Override
	public boolean addProductToWishList(Product product, Customer customer) {
		return false;
	}

	@Override
	public List<Product> readProductsInWishList(Customer customer) {
		return null;
	}

	@Override
	public boolean checkIfProductAvailableInWishList(Product product) {
		return false;
	}

	@Override
	public void deleteProductFromWishList(Product product) {

	}

}
