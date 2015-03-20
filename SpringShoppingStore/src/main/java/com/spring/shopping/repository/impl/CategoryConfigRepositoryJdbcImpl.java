package com.spring.shopping.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.spring.shopping.model.Category;
import com.spring.shopping.model.Product;
import com.spring.shopping.model.SubCategory;
import com.spring.shopping.repository.CategoryConfigRepository;
import com.spring.shopping.util.CategoryMapper;
import com.spring.shopping.util.ProductMapper;
import com.spring.shopping.util.SubCategoryMapper;

@Repository
public class CategoryConfigRepositoryJdbcImpl implements CategoryConfigRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Category> readAllCategories() {
		String sql = "SELECT * FROM category c;";
		List<Category> categoryList = jdbcTemplate.query(sql,
				new CategoryMapper());
		return categoryList;
	}

	@Override
	public List<SubCategory> readAllSubCategories() {
		String sql = "SELECT * FROM category sc;";
		List<SubCategory> subCategoryList = jdbcTemplate.query(sql,
				new SubCategoryMapper());
		return subCategoryList;
	}

	@Override
	public Long readCategoryByProductId(Product product) {
		String sql = "SELECT p.Category_Id from product p where p.Product_Id = :productId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"productId", product.getProductId());
		Long categoryId = namedParameterJdbcTemplate.queryForLong(sql,
				sqlParameterSource);
		return categoryId;
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
	public Long readSubCategoryByProductId(Product product) {
		String sql = "SELECT p.SubCategory_Id from product p where p.Product_Id = :productId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"productId", product.getProductId());
		Long subCategoryId = namedParameterJdbcTemplate.queryForLong(sql,
				sqlParameterSource);
		return subCategoryId;
	}

	@Override
	public List<SubCategory> readAllSubCategoriesByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM subcategory s where s.Category_Id = :categoryId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"categoryId", categoryId);
		List<SubCategory> subCategoryList = namedParameterJdbcTemplate.query(
				sql, sqlParameterSource, new SubCategoryMapper());
		return subCategoryList;
	}

	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		String sql = "SELECT * FROM product p where p.Category_Id = (SELECT c.Category_Id FROM category c where c.Name = :categoryName)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"categoryName", categoryName);
		List<Product> productList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource, new ProductMapper());
		return productList;
	}

	@Override
	public List<Product> getProductsBySubCategory(String subCategoryName) {
		String sql = "SELECT * FROM product p where p.SubCategory_Id = (SELECT sc.SubCategory_Id FROM subcategory sc where sc.Name = :subCategoryName)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"subCategoryName", subCategoryName);
		List<Product> subCatProdList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource, new ProductMapper());
		return subCatProdList;
	}

}
