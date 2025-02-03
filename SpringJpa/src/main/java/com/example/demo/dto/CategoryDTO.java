package com.example.demo.dto;

import com.example.demo.entity.Category;

public class CategoryDTO {
	
	 private Integer categoryId;
	 private String name;

	 public CategoryDTO(Category category) {
	        this.categoryId = category.getCategoryId();
	        this.name = category.getName();
	 }

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	 

}
