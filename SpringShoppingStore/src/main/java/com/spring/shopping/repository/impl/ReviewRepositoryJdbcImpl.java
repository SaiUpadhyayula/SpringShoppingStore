package com.spring.shopping.repository.impl;

import org.springframework.stereotype.Repository;

import com.spring.shopping.model.ReviewForm;
import com.spring.shopping.repository.ReviewRepository;

@Repository
public class ReviewRepositoryJdbcImpl implements ReviewRepository {
	
	@Override
	public void reviewProduct(ReviewForm reviewForm, Long productId) {
		
	}

}
