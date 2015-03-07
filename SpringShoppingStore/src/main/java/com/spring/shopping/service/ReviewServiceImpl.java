package com.spring.shopping.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.ReviewForm;
import com.spring.shopping.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public void reviewProduct(ReviewForm reviewForm) throws ParseException {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(date);
		Date presentDate = dateFormat.parse(formattedDate);
		java.sql.Date sqlDate = new java.sql.Date(presentDate.getTime());
		reviewForm.setDate(sqlDate);
		reviewRepository.reviewProduct(reviewForm);
	}

	@Override
	public List<ReviewForm> getProductReviews(Long productId)
			throws ParseException {
		List<ReviewForm> reviewsList = reviewRepository
				.getProductReviews(productId);
		return reviewsList;
	}

	@Override
	public List<ReviewForm> getReviewByCustomer(Customer customer) {
		List<ReviewForm> reviewsList =  reviewRepository.getReviewByCustomer(customer);
		return reviewsList;
	}

}
