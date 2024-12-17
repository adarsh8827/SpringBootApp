package com.example.spring.Dtos;



import com.example.spring.models.Category;
import com.example.spring.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {

	private String title;

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
	public Category getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(Category categoryName) {
		this.categoryName = categoryName;
	}
	private String description;
	private Double price;
	private String imageUrl;
	private Category categoryName;
	public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        product.setCategory(this.categoryName);

        return product;
    }

}
