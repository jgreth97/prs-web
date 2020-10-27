package com.prs.web;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.Product;
import com.prs.db.ProductRepo;


@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	// list all Products
		@GetMapping("/")
			public List<Product> getallProducts() {
				return productRepo.findAll();
		}
   // get product by id 
		@GetMapping("/{id}")
			public Optional<Product> getProduct(@PathVariable int id) {
			Optional<Product> pp = productRepo.findById(id);
				if (pp.isPresent()) {
				return pp;
				}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
				}
			}
	// add all Products
			@PostMapping("/")
			public Product addProduct(@RequestBody Product pp) {   //in the incoming request there is a body(Product)
				return productRepo.save(pp);
			}
			
	//update a Product
			@PutMapping("/{id}")
			public Product updateProduct(@RequestBody Product pp, @PathVariable int id) { //in the incoming request there is a body(Product)
				if (id==pp.getId()) {
				return productRepo.save(pp);
			}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id does not match");
				}
			}
	//delete a Product
			@DeleteMapping("/{id}")
			public Optional<Product> deleteProduct(@PathVariable int id) { //in the incoming request there is a body(Product)
			Optional<Product> pp = productRepo.findById(id);
			if (pp.isPresent()) {
				productRepo.deleteById(id);;
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");	
			}
			return pp;
			
		}
	
}
