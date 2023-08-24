package com.Ecommerce.ProductsMicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ProductsMicroservice.model.Category;
import com.Ecommerce.ProductsMicroservice.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Add custom query methods if needed
	List<Product> findAllByCategory(Category category);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> findProductsContainingName(String name);
}

