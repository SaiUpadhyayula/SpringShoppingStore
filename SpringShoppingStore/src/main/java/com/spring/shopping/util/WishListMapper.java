package com.spring.shopping.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.shopping.model.WishList;

public class WishListMapper implements RowMapper<WishList> {

	@Override
	public WishList mapRow(ResultSet rs, int rowNum) throws SQLException {
		WishList wishList = new WishList();
		wishList.setCustomerId(rs.getLong("Customer_Id"));
		wishList.setProductId(rs.getLong("Product_Id"));
		return wishList;
	}

}