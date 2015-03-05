package com.spring.shopping.repository;

import com.spring.shopping.model.ReviewForm;

public interface ReviewRepository {
	void reviewProduct(ReviewForm reviewForm,Long productId);
}
