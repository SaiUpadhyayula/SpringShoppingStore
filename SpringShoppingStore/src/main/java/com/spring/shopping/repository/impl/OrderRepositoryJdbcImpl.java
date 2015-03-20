package com.spring.shopping.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.spring.shopping.model.AddressForm;
import com.spring.shopping.model.Customer;
import com.spring.shopping.model.Order;
import com.spring.shopping.model.OrderItem;
import com.spring.shopping.model.Product;
import com.spring.shopping.repository.OrderRepository;
import com.spring.shopping.service.CategoryConfigService;
import com.spring.shopping.util.OrderMapper;
import com.spring.shopping.util.ProductMapper;

@Repository
public class OrderRepositoryJdbcImpl implements OrderRepository {

	@Autowired
	private CategoryConfigService categoryConfigService;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createOrder(final Order order, List<OrderItem> orderItemsList,
			AddressForm address) {
		Order order1 = order;
		order1.setAddressId(address.getAddressId());
		String sql = "insert into orders (Order_Id,CreatedDate,Email_Address,Order_Status,Order_SubTotal,Customer_Id,Address_Id) values (:orderId,:createdDate,:emailAddress,:orderStatus,:orderTotal,:customerId,:addressId)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				order1);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);

		for (OrderItem item : orderItemsList) {
			final Product product = item.getProduct();
			final String name = product.getName();
			final BigDecimal price = product.getPrice();
			final Integer quantity = item.getQuantity();
			final Long categoryId = categoryConfigService
					.getCategoryByProductId(product);
			final Long subCategoryId = categoryConfigService
					.getSubCategoryByProductId(product);
			String orderItemsSql = "insert into orderitem (Name,Price,Quantity,Category_Id,SubCategory_Id,Order_Id,Product_Id) values (?,?,?,?,?,?,?)";

			Object[] args = new Object[] { name, price, quantity, categoryId,
					subCategoryId, order.getOrderId(), product.getProductId() };

			jdbcTemplate.update(orderItemsSql, args);
		}
	}

	@Override
	public List<Product> readAllOrderItems(Order order) {
		String sql = "SELECT * FROM product p where p.Product_Id IN (SELECT oi.Product_Id FROM orderitem oi where oi.Order_Id = :orderId)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"orderId", order.getOrderId());
		List<Product> productList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource, new ProductMapper());
		return productList;
	}

	@Override
	public List<Order> readAllOrdersForCustomer(Customer customer) {
		String sql = "SELECT * FROM orders o where o.Customer_Id=:customerId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"customerId", customer.getCustomerId());
		List<Order> ordersList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource, new OrderMapper());
		return ordersList;
	}

	@Override
	public Order readOrderById(Long orderId) {
		String sql = "SELECT * FROM orders o where o.Order_Id=:orderId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("orderId", orderId);
		return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new OrderMapper());
		
	}
}