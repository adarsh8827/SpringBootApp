package com.example.spring.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.spring.Dtos.FakeStoreProductRequestDto;
import com.example.spring.Dtos.FakeStoreProductResponseDto;
import com.example.spring.models.Product;

@Service("FAKESTOREservice")
public class FakeStoreServiceimpl implements ProductService{
	
	private RestTemplate resttemplate;
	public FakeStoreServiceimpl(RestTemplate resttemplate) {
		this.resttemplate=resttemplate;
	}
	

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		FakeStoreProductRequestDto fakestoredto = new FakeStoreProductRequestDto();
		fakestoredto.setCategory(product.getCategoryName());
		fakestoredto.setDescription(product.getDescription());
		fakestoredto.setImage(product.getImageUrl());
		fakestoredto.setPrice(product.getPrice());
		fakestoredto.setTitle(product.getTitle());
		FakeStoreProductResponseDto respose = resttemplate.postForObject("https://fakestoreapi.com/products", fakestoredto, FakeStoreProductResponseDto.class);
		
		Product product1 = new Product();
		product1.setCategoryName(respose.getCategory());
		product1.setDescription(respose.getDescription());
		product1.setId(respose.getId());
		product1.setImageUrl(respose.getImage());
		product1.setPrice(respose.getPrice());
		product1.setTitle(respose.getTitle());
		return product1;
	}


	@Override
	public List<Product> getallproducts() {
	  FakeStoreProductResponseDto[] getfakestoreproduct =resttemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductResponseDto[].class);
      List<FakeStoreProductResponseDto> responseDtoList =
      Stream.of(getfakestoreproduct).toList();
      List<Product> products = new ArrayList<>();
      for(FakeStoreProductResponseDto pro:getfakestoreproduct) {
    	  products.add(pro.toProduct());
      }

		return products;
	}

}
