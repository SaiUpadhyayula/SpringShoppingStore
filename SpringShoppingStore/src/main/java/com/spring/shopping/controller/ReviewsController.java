package com.spring.shopping.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Product;
import com.spring.shopping.model.ReviewForm;
import com.spring.shopping.service.ProductConfigService;
import com.spring.shopping.service.ReviewService;
import com.spring.shopping.util.SessionUtils;

@Controller
public class ReviewsController {

	private String reviewsPage = "template/reviews-ratings";

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ProductConfigService productConfigService;
	@SuppressWarnings("unused")
	private HttpSession session;

	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public String getReviewsPage(HttpServletRequest request, Model model) {
		model.addAttribute("page", reviewsPage);
		session = SessionUtils.createSession(request);
		Customer customer = SessionUtils.getSessionVariables(request, "customer");
		if (customer != null) {
			List<ReviewForm> reviewList = reviewService
					.getReviewByCustomer(customer);
			Map<Product,ReviewForm> productReviews = new HashMap<Product,ReviewForm>();
			for (ReviewForm review : reviewList) {
				Product product = productConfigService.getProductById(review
						.getProductId());
				productReviews.put(product, review);
				
			}
			model.addAttribute("customerReviews", productReviews);
		}
		return "account";
	}

	@RequestMapping(value = "/reviews/product", method = RequestMethod.POST)
	public String reviewProduct(HttpServletRequest request, Model model,
			@ModelAttribute("review") ReviewForm reviewForm)
			throws ParseException {
		String reviewTitle = (String) request.getParameter("reviewTitle");
		String reviewText = (String) request.getParameter("reviewText");
		Long productId = Long.parseLong(request.getParameter("productId"));
		reviewForm.setReviewTitle(reviewTitle);
		reviewForm.setReviewText(reviewText);
		reviewForm.setProductId(productId);
		Customer customer = (Customer) request.getSession().getAttribute(
				"customer");
		String rating = request.getParameter("rating");
		reviewForm.setCustomerId(customer.getCustomerId());
		reviewForm.setRating(rating);
		reviewService.reviewProduct(reviewForm);
		return "redirect:/product?productId=" + productId;
	}

}