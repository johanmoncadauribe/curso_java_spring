package com.platzi.springboot.supermercado.persistence.mapper;

import java.util.List;

import org.mapstruct.*;

import com.platzi.springboot.supermercado.domain.domain.Product;
import com.platzi.springboot.supermercado.persistence.entity.Producto;

@Mapper(componentModel ="spring", uses = {CategoryMapper.class})
public interface ProductMapper {

	@Mappings({
		@Mapping(source="idProducto",target="productId"),
		@Mapping(source="nombre",target="name"),
		@Mapping(source="idCategoria",target="categoryId"),
		@Mapping(source="precioVenta",target="price"),
		@Mapping(source="cantidadStock",target="stock"),
		@Mapping(source="estado",target="active"),
		@Mapping(source="categoria",target="category"),
	})
	Product toProduct(Producto producto);
	List<Product> toProducts(List<Producto> productos);
	
	@InheritInverseConfiguration
	@Mapping(target="codigoBarras",ignore=true)
	Producto toProducto(Product product);
	
}
