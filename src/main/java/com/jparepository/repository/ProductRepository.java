package com.jparepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jparepository.entity.ProductEntity;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long>{

}
