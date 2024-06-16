package com.jparepository.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
@Data
@Entity(name = "Category")
public class CategoryEntity {
	@Id
	@UuidGenerator(style = Style.AUTO)
	private UUID id;
	@Column(unique = true)
	private String name;
}
