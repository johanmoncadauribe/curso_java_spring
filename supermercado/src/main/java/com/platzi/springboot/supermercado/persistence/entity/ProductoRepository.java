package com.platzi.springboot.supermercado.persistence.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.springboot.supermercado.domain.domain.Product;
import com.platzi.springboot.supermercado.domain.repository.ProductRepository;
import com.platzi.springboot.supermercado.persistence.crud.ProductoCrudRepository;
import com.platzi.springboot.supermercado.persistence.mapper.ProductMapper;
/*
 * con la siguiente etiqueta se especifica que la clase interactua con la BD. 
 */
@Repository
public class ProductoRepository implements ProductRepository{

	@Autowired
	private ProductoCrudRepository productoRepository;
	
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public List<Product> getAll(){
		List<Producto> productos=(List<Producto>) productoRepository.findAll();
		return mapper.toProducts(productos);
	}
	
	/*
	 * se hace llamado al metodo definido con sql
	 */
	
	public List<Producto> getByCategoriaSQL(int idCategoria){
		return (List<Producto>) productoRepository.getIdCategoria(idCategoria);
	}


	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		// TODO Auto-generated method stub
		List<Producto> productos=productoRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		// TODO Auto-generated method stub
		Optional<List<Producto>> productos= productoRepository.findByCantidadStockLessThanAndEstado(quantity,true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		// TODO Auto-generated method stub
		return productoRepository.findById(productId).map(producto->mapper.toProduct(producto));
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		Producto producto=mapper.toProducto(product);
		return mapper.toProduct(productoRepository.save(producto));
	}

	@Override
	public void delete(int productId) {
		// TODO Auto-generated method stub
			productoRepository.deleteById(productId);
	}
}
