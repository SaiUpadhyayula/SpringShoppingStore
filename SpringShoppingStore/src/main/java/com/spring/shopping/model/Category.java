package com.spring.shopping.model;

public class Category {
	
	private Long categoryId;

	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public Long getcategoryId() {
		return categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setId(Long id) {
		this.categoryId = id;
	}
}
