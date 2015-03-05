package com.spring.shopping.repository;

import java.util.List;

import com.spring.shopping.model.Category;
import com.spring.shopping.model.Product;
import com.spring.shopping.model.SubCategory;

public interface CategoryConfigRepository {

	List<Category> readAllCategories();

	List<SubCategory> readAllSubCategories();

	Long readCategoryByProductId(Product product);

	Category readCategoryBySubCategoryId(Long subCategoryId);

	Category readCategoryBySubCategoryName(String subCategoryName);

	List<SubCategory> readSubCategoryByCategoryId(Category category);

	SubCategory readSubCategoryByCategoryName(Category category);

	Long readSubCategoryByProductId(Product Product);

	List<SubCategory> readAllSubCategoriesByCategoryId(
			Long categoryId);

	List<Product> getProductsByCategory(String categoryName);

	List<Product> getProductsBySubCategory(String subCategoryName);

}
