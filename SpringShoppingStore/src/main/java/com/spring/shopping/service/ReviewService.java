package com.spring.shopping.service;

import com.spring.shopping.model.ReviewForm;

public interface ReviewService {
	void reviewProduct(ReviewForm reviewForm,Long productId);
}
