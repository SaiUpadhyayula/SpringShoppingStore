package com.spring.shopping.util;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.shopping.model.Product;

@SuppressWarnings("serial")
public class ProductMapper implements RowMapper<Product>,Serializable{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getLong("Product_Id"));
		product.setName(rs.getString("Name"));
		product.setFeatured(rs.getInt("Featured"));
		product.setPrice(rs.getBigDecimal("Price"));
		product.setAvailable(rs.getInt("Available"));
		product.setDescription(rs.getString("Description"));
		product.setManufacturer(rs.getString("Manufacturer"));
		
		return product;
	}

}