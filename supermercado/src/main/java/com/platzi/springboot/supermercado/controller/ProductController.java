package com.platzi.springboot.supermercado.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.platzi.springboot.supermercado.domain.domain.Product;
import com.platzi.springboot.supermercado.domain.service.ProductService;

@RestController
@RequestMapping(path="products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path="/getAll")
	public ResponseEntity<List<Product>> getAll(){
		try {
			return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
		}catch(Exception ex){
			System.out.println("exception getAll products:  "+ex);
			return null;
		}
	}

	//como productService retorna es un optional, la estrucutra es la siguiente
	@GetMapping(path="/getProduct/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
		try {
			return productService.getProduct(productId).map(product -> new ResponseEntity<>(product,HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}catch(Exception ex){
			System.out.println("exception getAll products:  "+ex);
			return null;
		}
	}

	@PostMapping(path="/save")
	public Product save(@RequestBody Product product) {
		try {
			return productService.save(product);
		} catch (Exception ex) {
			System.out.println("exception getAll products:  " + ex);
			return null;
		}
	}

		@DeleteMapping(path="/delete/{id}")
		public ResponseEntity delete(@PathVariable("id") Integer productId) {
			if( productService.delete(productId)){
				return new ResponseEntity<>(HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	}

