package com.spring.shopping.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.shopping.model.ReviewForm;

public class ReviewMapper implements RowMapper<ReviewForm> {

	@Override
	public ReviewForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewForm review = new ReviewForm();
		review.setCustomerId(rs.getLong("Customer_Id"));
		review.setReviewId(rs.getLong("Review_Id"));
		review.setReviewText(rs.getString("ReviewText"));
		review.setDate(rs.getDate("SubmittedDate"));
		review.setReviewTitle(rs.getString("ReviewTitle"));
		review.setRating(rs.getString("Rating"));
		review.setProductId(rs.getLong("Product_Id"));
		return review;
	}

}
