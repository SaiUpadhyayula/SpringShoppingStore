package com.spring.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.shopping.controller.constants.ControllerConstants;
import com.spring.shopping.model.Customer;
import com.spring.shopping.service.CartData;
import com.spring.shopping.service.CartService;
import com.spring.shopping.util.SessionUtils;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
//	@Autowired
//	private ProductConfigService productService;
//	@Autowired
//	private WishListService wishListService;
//	@Autowired
//	private CartData cartData;

	private final static String cartPage = "cart";
	private final static String redirectView = "redirect:/cart";

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
		// When a customer adds a product to the cart, we have to check
		// if he is a registered or an anonymous customer.
		Customer customer = SessionUtils.getSessionVariables(request,
				ControllerConstants.CUSTOMER);
		if (customer != null) {
			// Customer is anonymous, so create a shared cart and add it to
			// session
			// Creates a new cart for the anonymous customer
			CartData anonymousCartData = cartService.getShoppingCart();
			SessionUtils.setSessionVariables(anonymousCartData, request,
					ControllerConstants.CART);
			cartService.addProduct(anonymousCartData, productId);
		} else {

			CartData customerCartData = null;
			customerCartData = SessionUtils.getSessionVariables(request,
					ControllerConstants.CART);
			if (customerCartData == null) {
				customerCartData = cartService.getShoppingCart();
				SessionUtils.setSessionVariables(customerCartData, request,
						ControllerConstants.CART);
				cartService.addProduct(customerCartData, productId);
			} else {
				cartService.addProduct(customerCartData, productId);
			}
			// TODO: Extend the add to cart functionality

			// When the customer is registered, cart contents must be
			// stored in the database, and stored in the session.
		}
		return getRedirectview();

	}

	/**
	 * Method to View the Items of Shopping Cart Retrieves the items to display
	 * in the shopping cart page
	 * 
	 * @author SaiUpadhyayula
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String viewCart(Model model, HttpServletRequest request) {
		return getCartpage();
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

	// TODO- Implement BindingResult and FormValidations
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCart(Model model, HttpServletRequest request) {
		Long productId = Long.parseLong(request.getParameter("productid"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		cartService.updateProduct(cartData, productId, quantity);
		return "redirect:/cart";
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
	public String removeProduct(
			@RequestParam(value = "productId") Long productId, Model model,
			HttpServletRequest request) {
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		cartService.removeProduct(cartData, productId);
		return getRedirectview();
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
	public String clearCart(Model model, HttpServletRequest request) {
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		cartService.clearCart(cartData);
		return getRedirectview();
	}

	public static String getRedirectview() {
		return redirectView;
	}

	public static String getCartpage() {
		return cartPage;
	}
}