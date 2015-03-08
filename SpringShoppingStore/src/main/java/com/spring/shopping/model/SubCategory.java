package com.spring.shopping.model;

public class SubCategory {

	private Long subCategoryId;
	private String subCategoryName;

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subCategoryId == null) ? 0 : subCategoryId.hashCode());
		result = prime * result
				+ ((subCategoryName == null) ? 0 : subCategoryName.hashCode());
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
		SubCategory other = (SubCategory) obj;
		if (subCategoryId == null) {
			if (other.subCategoryId != null)
				return false;
		} else if (!subCategoryId.equals(other.subCategoryId))
			return false;
		if (subCategoryName == null) {
			if (other.subCategoryName != null)
				return false;
		} else if (!subCategoryName.equals(other.subCategoryName))
			return false;
		return true;
	}

}
