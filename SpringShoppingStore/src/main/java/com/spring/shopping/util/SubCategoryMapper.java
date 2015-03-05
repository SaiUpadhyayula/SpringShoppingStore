package com.spring.shopping.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.shopping.model.SubCategory;

public class SubCategoryMapper implements RowMapper<SubCategory> {

	@Override
	public SubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubCategory subCategory = new SubCategory();
		subCategory.setSubCategoryId(rs.getLong("SubCategory_Id"));
		subCategory.setSubCategoryId(rs.getLong("Category_Id"));
		subCategory.setSubCategoryName(rs.getString("Name"));
		return subCategory;
	}
}
