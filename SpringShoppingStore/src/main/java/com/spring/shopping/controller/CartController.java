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

import com.spring.shopping.controller.constants.ControllerConstants;
import com.spring.shopping.model.Customer;
import com.spring.shopping.service.CartData;
import com.spring.shopping.service.CartService;
import com.spring.shopping.service.ProductConfigService;
import com.spring.shopping.service.WishListService;
import com.spring.shopping.util.SessionUtils;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ProductConfigService productService;
	@Autowired
	private WishListService wishListService;
	@SuppressWarnings("unused")
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
		// When a customer adds a product to the cart, we have to check
		// if he is a registered or an anonymous customer.
		Customer customer = SessionUtils.getSessionVariables(request,
				ControllerConstants.CUSTOMER);
		if (customer == null) {
			// Customer is anonymous, so create a shared cart and add it to
			// session
			// We use the IP Address & Remote Port to identify
			// the cart contents of a customer.
			// Add this information to be accessed in the session.
			String ipAddr = request.getRemoteAddr();
			String host = request.getRemoteHost();
			ipAddr.replace(".", "");
			String customerIdentity = ipAddr + host;

			// Creates a new cart for the anonymous customer
			cartService.addProduct(productId);
			CartData anonymousCartData = cartService.getShoppingCart();

			// Store the Anonymous Cart Data in the Session
			SessionUtils.setSessionVariables(anonymousCartData, request,
					customerIdentity);
		} else {
			// Customer is registered, then check whether a shopping cart exists
			// in Database
			// If there is no shopping cart in Database, then create a shopping
			// cart and store it
			CartData cartData = cartService.getShoppingCartByCustomer(customer);

			if (cartData == null) {
				cartService.addProduct(productId);
				cartData = cartService.getShoppingCart();
				cartService.saveShoppingCartDetails(cartData, customer);
			} else {
				// If there is shopping cart in Database, add the products
				// to the existing shopping cart and save them back in database.
				cartService.setShoppingCart(cartData);
				cartService.addProduct(productId);
				cartService.saveCartInDatabase(cartData, customer);
			}
			// Store the Customer Cart Data in the Session
			SessionUtils.setSessionVariables(cartData, request, customer
					.getCustomerId().toString());
		}

		int numberOfItems = cartService.getNumberOfItems();
		model.addAttribute("prodList", cartService.getProductsList());
		model.addAttribute("numberOfItems", numberOfItems);
		model.addAttribute("cartTotal", cartService.getTotal());
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
		session = SessionUtils.createSession(request);
		SessionUtils.setSessionVariables(cartService, request, "cart");
		model.addAttribute("prodList", cartService.getProductsList());
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

	// TODO- Implement BindingResult and FormValidations
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