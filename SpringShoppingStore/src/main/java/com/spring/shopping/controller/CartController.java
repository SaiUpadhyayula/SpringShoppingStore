package com.spring.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.shopping.service.CartService;
import com.spring.shopping.service.ProductConfigService;
import com.spring.shopping.service.WishListService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ProductConfigService productService;
	@Autowired
	private WishListService wishListService;
	private HttpSession session;

	/**
	 * Method to Add Products to the Shopping Cart First Check if the Product is
	 * available in the Wishlist, if available, remove the product from Wishlist
	 * 
	 * @author Sai Upadhyayula
	 * 
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Product Page View
	 */
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProducts(Model model,
			@RequestParam(value = "productId") Long productId,
			HttpServletRequest request) {
		// check for the product in wishlist
		wishListService.checkIfProductAvailableInWishList(productId);
		if (cartService.containsProduct(productId)) {
			cartService.incrementProductQuantity(productId);
		} else {
			cartService.addProduct(productId);
		}
		model.addAttribute("cart", cartService);
		model.addAttribute("prodList", cartService.getProductsList());
		int numberOfItems = cartService.getNumberOfItems();
		model.addAttribute("numberOfItems", numberOfItems);
		session = request.getSession();
		session.setAttribute("cartTotal", cartService.getTotal());
		return "redirect:/cart";
	}

	/**
	 * Method to View the Items of Shopping Cart Retrieves the items to display
	 * in the shopping cart page
	 * 
	 * @author Sai Upadhyayula
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView viewCart(Model model, HttpServletRequest request) {
		session = request.getSession();
		session.setAttribute("cart", cartService);
		session.setAttribute("prodList", cartService.getProductsList());

		int numberOfItems = cartService.getNumberOfItems();
		model.addAttribute("numberOfItems", numberOfItems);
		return new ModelAndView("cart");
	}

	/**
	 * Method to Update the shopping cart page
	 * 
	 * @author Sai Upadhyayula
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	
	//TODO- Implement BindingResult and FormValidations
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateCart(Model model, HttpServletRequest request) {
		Long productId = Long.parseLong(request.getParameter("productid"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cartService.updateProduct(productId, quantity);
		model.addAttribute("cart", cartService);
		model.addAttribute("prodList", cartService.getProductsList());
		model.addAttribute("cartTotal", cartService.getTotal());
		int numberOfItems = cartService.getNumberOfItems();
		model.addAttribute("numberOfItems", numberOfItems);
		return new ModelAndView("cart", "cart", cartService);
	}

	/**
	 * Method to Remove the Products from shopping cart
	 * 
	 * @author Sai Upadhyayula
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public ModelAndView removeProduct(
			@RequestParam(value = "productId") Long productId, Model model,
			HttpServletRequest request) {
		cartService.removeProduct(productId);
		int numberOfItems = cartService.getNumberOfItems();
		model.addAttribute("numberOfItems", numberOfItems);
		model.addAttribute("cart", cartService);
		return new ModelAndView("cart", "cart", cartService);
	}

	/**
	 * Method to Clear the Products from shopping cart
	 * 
	 * @author Sai Upadhyayula
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public ModelAndView clearCart(Model model) {
		cartService.clearCart();
		int numberOfItems = cartService.getNumberOfItems();
		model.addAttribute("numberOfItems", numberOfItems);
		return new ModelAndView("cart");
	}
}
