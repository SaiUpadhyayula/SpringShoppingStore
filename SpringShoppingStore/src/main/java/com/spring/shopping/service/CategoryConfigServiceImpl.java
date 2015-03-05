package com.spring.shopping.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopping.model.Category;
import com.spring.shopping.model.Product;
import com.spring.shopping.model.SubCategory;
import com.spring.shopping.repository.CategoryConfigRepository;

@Service
public class CategoryConfigServiceImpl implements CategoryConfigService {
	@Autowired
	private CategoryConfigRepository categoryConfigRepository;

	/**
	 * Method to Get All Categories
	 * 
	 * @returns Categories List
	 */
	@Override
	public List<Category> getAllCategories() {
		List<Category> categoryList = categoryConfigRepository
				.readAllCategories();
		return categoryList;
	}

	/**
	 * Method to Get All SubCategories
	 * 
	 * @returns SubCategories List
	 */
	@Override
	public List<SubCategory> getAllSubCategories() {
		// Code to Retrieve All SubCategories
		// in the Application
		return null;
	}

	/**
	 * Method to Get a Category by a given Product ID
	 * 
	 * @returns Category
	 */
	@Override
	public Long getCategoryByProductId(Product product) {
		Long categoryId = categoryConfigRepository
				.readCategoryByProductId(product);
		return categoryId;
	}

	/**
	 * Method to Get a Category by a given SubCategory ID
	 * 
	 * @returns Category
	 */
	@Override
	public Category getCategoryBySubCategoryId() {
		// Code to Retrieve Category By SubCategory ID
		// in the Application
		return null;
	}

	/**
	 * Method to Get a Category by a given SubCategory Name
	 * 
	 * @returns Category
	 */
	@Override
	public Category getCategoryBySubCategoryName() {
		// TODO
		// Code to Retrieve Category By SubCategory Name
		// in the Application
		return null;
	}

	/**
	 * Method to Get a SubCategory by a given Category ID
	 * 
	 * @returns SubCategory
	 */
	@Override
	public SubCategory getSubCategoryByCategoryId() {
		// Code to Retrieve SubCategory By Category ID
		// in the Application
		return null;
	}

	/**
	 * Method to Get a SubCategory by a given Category Name
	 * 
	 * @returns Category
	 */
	@Override
	public SubCategory getSubCategoryByCategoryName() {
		// Code to Retrieve SubCategory By Category Name
		// in the Application
		return null;
	}

	/**
	 * Method to Get a SubCategory by a given Product Id
	 * 
	 * @returns SubCategory
	 */
	@Override
	public Long getSubCategoryByProductId(Product product) {
		Long subCategoryId = categoryConfigRepository
				.readSubCategoryByProductId(product);
		return subCategoryId;
	}

	/**
	 * Method to Get a SubCategory by a given Product Id
	 * 
	 * @returns Map of Category and List<SubCategory>
	 */
	@Override
	public List<SubCategory> getAllSubCategoriesByCategoryId(Long categoryId) {
		List<SubCategory> subCatList = categoryConfigRepository
				.readAllSubCategoriesByCategoryId(categoryId);
		return subCatList;
	}

	public Map<Category, List<SubCategory>> getCategoriesMap() {

		List<Category> categoriesList = getAllCategories();
		Map<Category, List<SubCategory>> categoryMap = new HashMap<Category, List<SubCategory>>();
		for (Category category : categoriesList) {
			List<SubCategory> subCategoryList = getAllSubCategoriesByCategoryId(category
					.getcategoryId());
			categoryMap.put(category, subCategoryList);
		}

		return categoryMap;
	}

	/**
	 * Method to Get List of Products by a given Category
	 * 
	 * @returns Map of List<Product>
	 */
	@Override
	public List<Product> getProductsByCategory(String categoryName) {

		List<Product> productsList = categoryConfigRepository
				.getProductsByCategory(categoryName);
		return productsList;
	}

	@Override
	public List<Product> getProductsBySubCategory(String subCategoryName) {
		List<Product> prodListBySubCat = categoryConfigRepository.getProductsBySubCategory(subCategoryName);
		return prodListBySubCat;
	}

}
