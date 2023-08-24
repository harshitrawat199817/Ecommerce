package com.Ecommerce.ProductsMicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ProductsMicroservice.model.Product;
import com.Ecommerce.ProductsMicroservice.service.CategoryService;
import com.Ecommerce.ProductsMicroservice.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> showProduct(){
		return ResponseEntity.ok(productService.allProducts());
	}
	@GetMapping("/products/{name}")
	public ResponseEntity<List<Product>> showProductByName(@RequestParam String name){
		return ResponseEntity.ok( productService.allProductsByName(name));
	}
	
	@PostMapping("/products/create")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		if(product==null) return ResponseEntity.badRequest().build();
		productService.addProduct(product);
		return new ResponseEntity<Product>(HttpStatus.CREATED );
	}
	
	@DeleteMapping("products/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@RequestParam Long id){
		productService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT );
	}
}
