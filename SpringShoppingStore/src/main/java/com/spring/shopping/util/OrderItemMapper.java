package com.spring.shopping.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.shopping.model.OrderItem;

public class OrderItemMapper implements RowMapper<OrderItem> {

	@Override
	public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(rs.getLong("OrderItem_Id"));
		orderItem.setOrderId(rs.getLong("Order_Id"));
		orderItem.setProductId(rs.getLong("Product_Id"));

		return orderItem;
	}

}
