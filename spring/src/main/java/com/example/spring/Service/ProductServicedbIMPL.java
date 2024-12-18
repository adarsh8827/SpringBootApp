package com.example.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring.Exceptions.ProductNotFoundException;
import com.example.spring.models.Category;
import com.example.spring.models.Product;
import com.example.spring.repository.CategoryRepository;
import com.example.spring.repository.ProductRepository;



@Service("DBProductservice")
public class ProductServicedbIMPL implements ProductService{
	private ProductRepository productrepo;
	private CategoryRepository categoryrepo;

	
	public ProductServicedbIMPL(ProductRepository productrepo,CategoryRepository categoryrepo) {
		this.productrepo=productrepo;
		this.categoryrepo=categoryrepo;
	}
    private Category getCategoryToBeInProduct(Product product) {
        String categoryName = product.getCategory().getName();

        Optional<Category> category =
        		categoryrepo.findByName(categoryName);
        Category toBePutInProduct = null;

        if (category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);
            toBePutInProduct = toSaveCategory;
            categoryrepo.save(toSaveCategory);
        } else {
            toBePutInProduct = category.get();
        }
        return toBePutInProduct;
    }

    @Override
    public Product createProduct(Product product) {
        Category toBePutInProduct = getCategoryToBeInProduct(product);

        product.setCategory(toBePutInProduct);

        Product savedProduct = productrepo.save(product);
        System.out.println("hahahhahaha");

        return savedProduct;
    }

    @Override
    public List<Product> getallproducts() {
        return  productrepo.findAll();
    }

    @Override
    public Product partialUpdateProduct(Long productId,
                                        Product product) throws ProductNotFoundException {

        Optional<Product> productToUpdateOptional = productrepo.findById(productId);

        if (productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product productToUpdate = productToUpdateOptional.get();

        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }

        if (product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }

        if (product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }

        if (product.getCategory() != null) {
            Category toBePutInProduct = getCategoryToBeInProduct(product);

            productToUpdate.setCategory(toBePutInProduct);
        }

        return productrepo.save(productToUpdate);
    }

	@Override
	public boolean deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		return false;
	}




}
