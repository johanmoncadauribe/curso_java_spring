package com.platzi.springboot.supermercado.domain.repository;

import java.util.*;

import com.platzi.springboot.supermercado.domain.domain.Product;

public interface ProductRepository {
	
	List<Product> getAll();
	Optional<List<Product>> getByCategory(int categoryId);
	Optional<List<Product>> getScarseProducts(int quantity);
	Optional<Product> getProduct(int productId);
	Product save(Product product);
	boolean delete(int productId);

}
