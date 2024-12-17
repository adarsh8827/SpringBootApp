package com.example.spring.Service;

import java.util.List;

import com.example.spring.models.Product;

public interface ProductService {
	Product createProduct(Product product);
	List<Product> getallproducts();
	Product partialUpdateProduct(Long productId, Product product);
	boolean deleteProductById(Long productId);

}
