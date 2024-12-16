package com.example.spring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.Dtos.CreateProductRequestDto;
import com.example.spring.Dtos.CreateProductResponseDto;
import com.example.spring.Dtos.GetProductResponseDto;
import com.example.spring.Service.ProductService;
import com.example.spring.models.Product;

@RestController
@RequestMapping("/products/")
public class ProductController {
	@Value("${service.name}")
    private String servicename;
	
	
	private ProductService productservice;
	
	public ProductController(@Qualifier("FAKESTOREservice") ProductService productservice) {
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
//	@RequestMapping(name = "ADARSH", value = "/products/")
//    public String getTestProduct() {
//        return "This is Adarsh Product";
//    }

}
