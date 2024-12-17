package com.example.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring.models.Category;
import com.example.spring.models.Product;

import repository.CategoryRepository;
import repository.ProductRepository;

@Service("DBProductservice")
public class ProductServicedbIMPL implements ProductService{
	private ProductRepository productrepo;
	private CategoryRepository categoryrepo;

	
	public ProductServicedbIMPL(ProductRepository productrepo,CategoryRepository categoryrepo) {
		this.productrepo=productrepo;
		this.categoryrepo=categoryrepo;
	}


	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		String categoryName = product.getCategory().getName();
		Category tobeputinnproduct = null;
		Optional<Category> category = categoryrepo.findByName(categoryName);
		if(category.isEmpty()) {
			Category tosavecategory = new Category(categoryName);
			tosavecategory.setName(categoryName);
			tobeputinnproduct =categoryrepo.save(tosavecategory);
			
		}else {
			tobeputinnproduct= category.get();
		}
		product.setCategory(tobeputinnproduct);
		Product saveproduct = productrepo.save(product);
		return saveproduct;
	}

	@Override
	public List<Product> getallproducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product partialUpdateProduct(Long productId, Product product) {
		
		return null;
	}

	@Override
	public boolean deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		return false;
	}



}
