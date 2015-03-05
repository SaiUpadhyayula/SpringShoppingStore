package com.spring.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.shopping.model.Product;
import com.spring.shopping.service.CartService;
import com.spring.shopping.service.CategoryConfigService;
import com.spring.shopping.service.ProductConfigService;

@Controller
public class ProductController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ProductConfigService productConfigurationService;
	@Autowired
	private CategoryConfigService categoryConfigurationService;

	/**
	 * Product Controller method which retrieves the information required in the
	 * product page
	 * 
	 * @author Sai Upadhyayula
	 * 
	 * @param Model
	 * @param ProductId
	 * @return Product Page View
	 */
	@RequestMapping(value = "/product", method = RequestMethod.GET, params = { "productId" })
	public String handleRequest(Model model,
			@RequestParam(value = "productId") Long productId) {
		Product product = productConfigurationService.getProductById(productId);
		model.addAttribute("product", product);
		int numberOfItems = cartService.getNumberOfItems();
		model.addAttribute("numberOfItems", numberOfItems);
		return "product";
	}
}
