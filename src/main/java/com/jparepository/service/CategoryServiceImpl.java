package com.jparepository.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jparepository.dto.CategoryDTO;
import com.jparepository.entity.CategoryEntity;
import com.jparepository.exception.EmptyListException;
import com.jparepository.exception.NoRecordFoundException;
import com.jparepository.repository.CategoryRepository;
import com.jparepository.util.JPAUtility;
@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepository;
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	@Override
	public CategoryDTO save(CategoryEntity entity)  {
		CategoryEntity savedEntity=categoryRepository.save(entity);
		return JPAUtility.entityToDTO(savedEntity);
	}

	@Override
	public List<CategoryDTO> getAllCategories() throws EmptyListException{
		List<CategoryEntity> categoryEntities= categoryRepository.findAll();
		if(categoryEntities.isEmpty()) {
			throw new EmptyListException("No records available");
		}
		List<CategoryDTO> categoryDTOs=new ArrayList<>();
		for(CategoryEntity entity:categoryEntities) {
			CategoryDTO dto=new CategoryDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			categoryDTOs.add(dto);
		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO getCategoryByUUID(UUID uuid) throws NoRecordFoundException {
		Optional<CategoryEntity> optionalEntity=categoryRepository.findById(uuid);
		if(optionalEntity.isEmpty()) {
			throw new NoRecordFoundException("Category doest not exist");
		}
		CategoryDTO dto=JPAUtility.entityToDTO(optionalEntity.get());
		return dto;
	}

	@Override
	public void deleteByUUID(UUID uuid) {
		// TODO Auto-generated method stub
		
	}

}
