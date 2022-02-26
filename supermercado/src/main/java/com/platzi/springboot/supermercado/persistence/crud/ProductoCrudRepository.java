package com.platzi.springboot.supermercado.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.platzi.springboot.supermercado.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

	
	/*
	 * ambos metodos retornan el mismo valor, uno usa consultas sql nativas y el otro usa los metodos de JPA definidos.
	 * retornan todos los productos que cumplan con la categoria
	 */
	@Query(value ="SELECT * FROM productos WHERE id_categoria=?",nativeQuery=true)
	List<Producto> getIdCategoria(int idCategoria);
	
	List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
	
	/*
	 * metodos para recuperar la cantidad de productos escasos
	 */
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, boolean estado);
	
}
