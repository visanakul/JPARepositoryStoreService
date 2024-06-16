package com.jparepository.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jparepository.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID>{
	CategoryEntity save(CategoryEntity entity);
	List<CategoryEntity> findAll();
	Optional<CategoryEntity> findById(UUID uuid);
	void deleteById(UUID uuid);
	
}
