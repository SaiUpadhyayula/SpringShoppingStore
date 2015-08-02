package com.spring.shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.shopping.model.Category;
import com.spring.shopping.model.Product;
import com.spring.shopping.model.SubCategory;
import com.spring.shopping.service.CategoryConfigService;
import com.spring.shopping.service.ProductConfigService;

/**
 * @author Sai Upadhyayula Handles requests for the application home page.
 */
@Controller
public class CatalogController {

	@Autowired
	private CategoryConfigService categoryConfigurationService;
	@Autowired
	private ProductConfigService productConfigurationService;
	@Autowired
	private ServletContext context;
//	@Autowired
//	private CartService cartService;

	private String accountsTemplatePage = "template/accountInformation";

	private String homePage = "home";

	private String categoryPage = "category";

	private String accountsPage = "account";

	private static final Logger logger = LoggerFactory
			.getLogger(CatalogController.class);

	/**
	 * Catalog Controller method which retrieves the information required in the
	 * application home page(Categories,SubCategories,Featured Items)
	 * 
	 * @author Sai Upadhyayula
	 * 
	 * @param Model
	 * @return Home Page View
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String returnHomePage(Model model, HttpServletRequest request) {
		Map<Category, List<SubCategory>> categoryMap = new HashMap<Category, List<SubCategory>>();
		logger.info("Processing information for home page");
		if (categoryMap.isEmpty()) {
			categoryMap = categoryConfigurationService.getCategoriesMap();
		}
		if (context.getAttribute("categoryMap") == null) {
			context.setAttribute("categoryMap", categoryMap);
		}
		List<Product> featProdList = new ArrayList<Product>();
		if (featProdList.isEmpty()) {
			model.addAttribute("featProd",
					productConfigurationService.getFeaturedProducts());
		}
		return getHomePage();
	}

	@RequestMapping(value = "/cateogry", method = RequestMethod.GET)
	public String fetchProductsByCategory(Model model,
			@RequestParam("category") String categoryName,
			HttpServletRequest request) {
		List<Product> categoryProducts = categoryConfigurationService
				.getProductsByCategory(categoryName);
		model.addAttribute("catProds", categoryProducts);
		return getCategoryPage();
	}

	@RequestMapping(value = "/subcateogry", method = RequestMethod.GET)
	public String fetchProductsBySubCategory(Model model,
			@RequestParam("subcategory") String subCategoryName,
			HttpServletRequest request) {
		List<Product> subCategoryProducts = categoryConfigurationService
				.getProductsBySubCategory(subCategoryName);
		model.addAttribute("subCatProds", subCategoryProducts);
		return getCategoryPage();
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String getAccountsPage(Model model, HttpServletRequest request) {
		model.addAttribute("page", accountsTemplatePage);
		return getAccountPage();
	}

	public String getAccountPage() {
		return accountsPage;
	}

	public String getCategoryPage() {
		return categoryPage;
	}

	public String getHomePage() {
		return homePage;
	}
}
