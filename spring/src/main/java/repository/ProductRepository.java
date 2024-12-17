package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//Create and upadte is done using same
	Product save(Product p);
	
	void delete(Product entity);
}
