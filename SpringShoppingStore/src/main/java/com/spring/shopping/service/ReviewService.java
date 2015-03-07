package com.spring.shopping.service;

import java.text.ParseException;
import java.util.List;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.ReviewForm;

public interface ReviewService {
	void reviewProduct(ReviewForm reviewForm) throws ParseException;

	List<ReviewForm> getProductReviews(
			Long productId) throws ParseException;

	List<ReviewForm> getReviewByCustomer(Customer customer);
}
