package com.spring.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.shopping.model.ReviewForm;
import com.spring.shopping.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public void reviewProduct(ReviewForm reviewForm, Long productId) {
		reviewRepository.reviewProduct(reviewForm, productId);
	}

}
