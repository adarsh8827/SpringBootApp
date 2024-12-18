package com.example.spring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.Dtos.CreateProductRequestDto;
import com.example.spring.Dtos.CreateProductResponseDto;
import com.example.spring.Dtos.GetProductResponseDto;
import com.example.spring.Dtos.PatchProductResponseDto;
import com.example.spring.Exceptions.ProductNotFoundException;
import com.example.spring.Service.ProductService;
import com.example.spring.models.Product;

@Controller
@RestController
@RequestMapping("/products/")
public class ProductController {
	@Value("${service.name}")
    private String servicename;
	
	
	private ProductService productservice;
	
	public ProductController(@Qualifier("DBProductservice") ProductService productservice) {
		this.productservice =productservice;
	}
	
	
	@PostMapping("")
	public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductDto) {
		Product product = productservice.createProduct(createProductDto.toProduct());
		return CreateProductResponseDto.fromProduct(product);
	}
	

	
	@GetMapping("")
	public List<GetProductResponseDto> getAllproduct() {
		List<Product> products = productservice.getallproducts();
		List<GetProductResponseDto> getproductresponsedto = new ArrayList<>();
		for(Product pro:products) {
			getproductresponsedto.add(GetProductResponseDto.from(pro));
		}
		return getproductresponsedto; 
	}
	@GetMapping("{id}")
	public String getSpecificproduct(@PathVariable("id") Long id1 ) {
		return "This is get Product : "+id1; 
	}
	
	@PatchMapping("{id}")
	public PatchProductResponseDto patchproduct(@PathVariable("id") Long id,@RequestBody CreateProductRequestDto productDto) throws ProductNotFoundException {
		
		Product product = productservice.partialUpdateProduct(id, productDto.toProduct());
//		PatchProductResponseDto response = new PatchProductResponseDto();
		PatchProductResponseDto.fromProduct(product);

		return PatchProductResponseDto.fromProduct(product);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
	    boolean isDeleted = productservice.deleteProductById(id);

	    if (isDeleted) {
	        return ResponseEntity.ok("Product with ID " + id + " has been successfully deleted.");
	    } else {
	        return ResponseEntity.status(404).body("Product with ID " + id + " not found.");
	    }
	}
//	@RequestMapping(name = "ADARSH", value = "/products/")
//    public String getTestProduct() {
//        return "This is Adarsh Product";
//    }

}
