package com.spring.shopping.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long productId;

	private String name;

	private Integer featured;

	private BigDecimal price;

	private Integer available;

	private String description;

	private String manufacturer;

	public static class ProductBuilder {
		private String name;
		private BigDecimal price;
		private String description;
		private String manufacturer;

		public ProductBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ProductBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}

		public ProductBuilder description(String description) {
			this.description = description;
			return this;
		}

		public ProductBuilder manufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}

	private Product(ProductBuilder productBuilder) {
		name = productBuilder.name;
		price = productBuilder.price;
		description = productBuilder.description;
		manufacturer = productBuilder.manufacturer;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFeatured() {
		return featured;
	}

	public void setFeatured(Integer featured) {
		this.featured = featured;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
