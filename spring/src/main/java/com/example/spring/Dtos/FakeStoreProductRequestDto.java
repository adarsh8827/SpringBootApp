package com.example.spring.Dtos;

import com.example.spring.models.Category;
import com.example.spring.models.Product;

public class FakeStoreProductRequestDto {
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String title;
	private double price;
	private String description;
	private String image;
	private Category category;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category2) {
		this.category = category2;
	}
    public static FakeStoreProductRequestDto fromProduct(Product product) {
    	FakeStoreProductRequestDto responseDto = new FakeStoreProductRequestDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImage(product.getImageUrl());

        return responseDto;
    }


}
