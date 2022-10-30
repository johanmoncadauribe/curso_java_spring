package com.platzi.springboot.supermercado.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.springboot.supermercado.domain.domain.Category;
import com.platzi.springboot.supermercado.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mappings({
		@Mapping(source="idCategoria",target="categoryId"),
		@Mapping(source="descripcion",target="category"),
		@Mapping(source="estado",target="active")
	})
	Category toCategory(Categoria categoria);
	
	@InheritInverseConfiguration// se le indica que la conversion del mapper es a la inversa
	@Mapping(target ="productos", ignore=true)
	Categoria toCategoria(Category category);
	
}
