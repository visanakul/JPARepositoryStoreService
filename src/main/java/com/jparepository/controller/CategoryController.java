package com.jparepository.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jparepository.dto.CategoryDTO;
import com.jparepository.entity.CategoryEntity;
import com.jparepository.exception.EmptyListException;
import com.jparepository.exception.NoRecordFoundException;
import com.jparepository.service.CategoryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/categories")
public class CategoryController {
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public CategoryDTO saveCategory(@RequestBody CategoryEntity entity) {
		return categoryService.save(entity);
	}
	
	@GetMapping
	public List<CategoryDTO> getAllCategories() throws EmptyListException {
		return categoryService.getAllCategories();
	}
	@GetMapping("/{uuid}")
	public CategoryDTO searchCategory(@PathVariable("uuid")String uuidStr) throws NoRecordFoundException {
		return categoryService.getCategoryByUUID(UUID.fromString(uuidStr));
	}
}