package com.jparepository.service;

import java.util.List;
import java.util.UUID;

import com.jparepository.dto.CategoryDTO;
import com.jparepository.entity.CategoryEntity;
import com.jparepository.exception.EmptyListException;
import com.jparepository.exception.NoRecordFoundException;


public interface CategoryService {
	CategoryDTO save(CategoryEntity entity);

	List<CategoryDTO> getAllCategories() throws EmptyListException;

	CategoryDTO getCategoryByUUID(UUID uuid) throws NoRecordFoundException;

	void deleteByUUID(UUID uuid);
}
