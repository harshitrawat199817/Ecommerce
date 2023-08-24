package com.Ecommerce.ProductsMicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ProductsMicroservice.model.Category;
import com.Ecommerce.ProductsMicroservice.model.Product;
import com.Ecommerce.ProductsMicroservice.repository.ProductRepository;
@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> allProductsByCategory(Category category){
		return productRepository.findAllByCategory(category);
	}
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	public List<Product> allProductsByName(String name){
		return productRepository.findProductsContainingName(name);
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
//	public Product findProduct(Long id) {
//		return productRepository.findById(id).get();
//	}
	
}
