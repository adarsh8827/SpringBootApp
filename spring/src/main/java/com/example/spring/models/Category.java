package com.example.spring.models;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Category extends BaseModel{

    private String name;
    public Category() {
        // Empty constructor
    }
    public Category(String name) {
    	this.name=name;
    }
    
    private String description;
    @OneToMany
    private List<Product> featuredProducts;
    @OneToMany(mappedBy = "category")
    private List<Product> allProducts;
	
    
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getFeaturedProducts() {
		return featuredProducts;
	}
	public void setFeaturedProducts(List<Product> featuredProducts) {
		this.featuredProducts = featuredProducts;
	}
	public List<Product> getAllProducts() {
		return allProducts;
	}
	public void setAllProducts(List<Product> allProducts) {
		this.allProducts = allProducts;
	}



}
