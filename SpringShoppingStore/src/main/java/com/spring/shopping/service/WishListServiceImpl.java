package com.spring.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Product;
import com.spring.shopping.repository.WishListRepository;

public class WishListServiceImpl implements WishListService {

	@Autowired
	private WishListRepository wishListRepository;
	@Autowired
	private ProductConfigService productConfigService;

	@Override
	public boolean addProductToWishList(Long productId, Customer customer) {
		Product product = productConfigService.getProductById(productId);
		return wishListRepository.addProductToWishList(product, customer);
		
	}

	@Override
	public List<Product> getProductsInWishList(Customer customer) {
		List<Product> prodcutsInWishList = wishListRepository.readProductsInWishList(customer);
		return prodcutsInWishList;
	}

	@Override
	public boolean checkIfProductAvailableInWishList(Long productId) {
		Product product = productConfigService.getProductById(productId);		
		return wishListRepository.checkIfProductAvailableInWishList(product);
	}
	
	public void deleteProductFromWishList(Long productId) {
		Product product = productConfigService.getProductById(productId);
		wishListRepository.deleteProductFromWishList(product);
	}
	

}
