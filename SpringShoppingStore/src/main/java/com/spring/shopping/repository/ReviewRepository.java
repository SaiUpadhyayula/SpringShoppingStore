package com.spring.shopping.repository;

import java.util.List;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.ReviewForm;

public interface ReviewRepository {
	void reviewProduct(ReviewForm reviewForm);

	List<ReviewForm> getProductReviews(Long productId);

	List<ReviewForm> getReviewByCustomer(Customer customer);
}
