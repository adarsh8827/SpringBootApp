package com.example.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//Create and upadte is done using same
    @Override
    Product save(Product p);

    @Override
    void delete(Product entity);

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
