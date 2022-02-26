package com.platzi.springboot.supermercado.persistence.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.platzi.springboot.supermercado.persistence.crud.ProductoCrudRepository;
/*
 * con la siguiente etiqueta se especifica que la clase interactua con la BD. 
 */
@Repository
public class ProductoRepository {

	private ProductoCrudRepository productoRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productoRepository.findAll();
	}
	
	/*
	 * se hace el llamado al metodos definido por jpa
	 */
	public List<Producto> getByCategoriaJPA(int idCategoria){
		return (List<Producto>) productoRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}
	/*
	 * se hace llamado al metodo definido con sql
	 */
	
	public List<Producto> getByCategoriaSQL(int idCategoria){
		return (List<Producto>) productoRepository.getIdCategoria(idCategoria);
	}
	
	public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
		return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, estado);
	}
	
	public Optional<Producto> getProducto(int idProducto){
		return productoRepository.findById(idProducto);
	}
	
	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public boolean deleteProducto(int idProducto) {
		try {
			productoRepository.deleteById(idProducto);
			return true;
		}catch(Exception io) {
			return false;
		}
	}
}
