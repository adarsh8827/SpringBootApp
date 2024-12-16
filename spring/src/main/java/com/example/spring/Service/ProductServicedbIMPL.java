package com.example.spring.Service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.spring.models.Product;

@Service("DBProductserive")
//@Primary
public class ProductServicedbIMPL implements ProductService{

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getallproducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
