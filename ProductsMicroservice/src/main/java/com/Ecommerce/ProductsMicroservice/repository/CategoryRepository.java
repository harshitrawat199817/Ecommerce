package com.Ecommerce.ProductsMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ProductsMicroservice.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Add custom query methods if needed
}

