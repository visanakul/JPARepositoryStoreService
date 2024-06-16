package com.jparepository.util;

import com.jparepository.dto.CategoryDTO;
import com.jparepository.entity.CategoryEntity;

public class JPAUtility {
	
	public static CategoryEntity dtoToEntity(CategoryDTO dto) {
		CategoryEntity entity=new CategoryEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
	
	public static CategoryDTO entityToDTO(CategoryEntity entity) {
		CategoryDTO dto=new CategoryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

}
