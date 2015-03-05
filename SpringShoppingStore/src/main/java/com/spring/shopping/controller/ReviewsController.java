package com.spring.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.ReviewForm;
import com.spring.shopping.service.ReviewService;

@Controller
public class ReviewsController {

	private String reviewsPage = "template/reviews-ratings";

	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public String getReviewsPage(HttpServletRequest request, Model model) {
		model.addAttribute("page", reviewsPage);
		return "account";
	}

	@RequestMapping(value = "/reviews/product/{productId}", method = RequestMethod.GET)
	public String reviewProduct(HttpServletRequest request, Model model,
			@ModelAttribute("review") ReviewForm reviewForm, Long productId) {
		String reviewTitle = (String) request.getAttribute("reviewTitle");
		String reviewText = (String) request.getAttribute("reviewText");
		reviewForm.setReviewTitle(reviewTitle);
		reviewForm.setReviewText(reviewText);
		Customer customer = (Customer) request.getSession().getAttribute(
				"customer");
		reviewForm.setCustomerId(customer.getCustomerId());
		reviewService.reviewProduct(reviewForm, productId);
		return "";
	}
}
