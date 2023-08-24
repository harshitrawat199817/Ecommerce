package com.Ecommerce.ProductsMicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Category {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long categoryId;
	@NotNull
	@NotBlank
	String categoryType;
	
	
	public Category() {
		super();
	}
	public Category(Long categoryId, @NotNull @NotBlank String categoryType) {
		super();
		this.categoryId = categoryId;
		this.categoryType = categoryType;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	
	
}
