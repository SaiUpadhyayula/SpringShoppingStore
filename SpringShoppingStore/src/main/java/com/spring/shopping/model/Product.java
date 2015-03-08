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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((available == null) ? 0 : available.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((featured == null) ? 0 : featured.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (available == null) {
			if (other.available != null)
				return false;
		} else if (!available.equals(other.available))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (featured == null) {
			if (other.featured != null)
				return false;
		} else if (!featured.equals(other.featured))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

}
