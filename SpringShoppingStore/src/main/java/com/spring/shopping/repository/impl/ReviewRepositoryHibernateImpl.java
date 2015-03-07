package com.spring.shopping.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.ReviewForm;
import com.spring.shopping.repository.ReviewRepository;

@Repository
public class ReviewRepositoryHibernateImpl implements ReviewRepository {

	@Override
	public void reviewProduct(ReviewForm reviewForm) {

	}

	@Override
	public List<ReviewForm> getProductReviews(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewForm> getReviewByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
