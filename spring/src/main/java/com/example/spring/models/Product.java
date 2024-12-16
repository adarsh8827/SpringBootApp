package com.example.spring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long d) {
		this.id = d;
	}
	private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String CategoryName;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
}
