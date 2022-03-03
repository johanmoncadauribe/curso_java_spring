package com.platzi.springboot.supermercado.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.platzi.springboot.supermercado.domain.domain.Product;
import com.platzi.springboot.supermercado.domain.service.ProductService;

@RestController
@RequestMapping(path="products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public List<Product> getAll(){
		try {
			return productService.getAll();
		}catch(Exception ex){
			System.out.println("exception getAll products:  "+ex);
			return null;
		}
	}
	
	public Optional<Product> getProduct(int productId){
		try {
			return productService.getProduct(productId);
		}catch(Exception ex){
			System.out.println("exception getAll products:  "+ex);
			return null;
		}
	}
	
	
	
}
