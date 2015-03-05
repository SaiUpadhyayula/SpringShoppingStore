package com.spring.shopping.repository.impl;

import java.util.List;

import com.spring.shopping.model.Category;
import com.spring.shopping.model.Product;
import com.spring.shopping.model.SubCategory;
import com.spring.shopping.repository.CategoryConfigRepository;

public class CategoryConfigRepositoryHibernateImpl implements
		CategoryConfigRepository {

	@Override
	public List<Category> readAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategory> readAllSubCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long readCategoryByProductId(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category readCategoryBySubCategoryId(Long subCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category readCategoryBySubCategoryName(String subCategoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategory> readSubCategoryByCategoryId(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory readSubCategoryByCategoryName(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long readSubCategoryByProductId(Product Product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategory> readAllSubCategoriesByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsBySubCategory(String subCategoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}
