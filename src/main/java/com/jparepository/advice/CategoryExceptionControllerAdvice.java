package com.jparepository.advice;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jparepository.exception.EmptyListException;
import com.jparepository.exception.NoRecordFoundException;

@ControllerAdvice
public class CategoryExceptionControllerAdvice {
	@ExceptionHandler
	public ResponseEntity<?> errorResponse(Exception exception){
		Map<String,String> map=new HashMap<>();
		map.put("Error",exception.getMessage());
		map.put("code", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity(map,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> errorContraintViolationHandler(DataIntegrityViolationException exception){
		Map<String,String> map=new HashMap<>();
		map.put("Error","Contraint violated: Duplicate category name.");
		map.put("code", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity(map,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler
	public ResponseEntity<?> errorEmptyListHandlern(EmptyListException exception){
		Map<String,String> map=new HashMap<>();
		map.put("Error",exception.getMessage());
		map.put("code", String.valueOf(HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> errorNoRecordFoundHandler(NoRecordFoundException exception){
		Map<String,String> map=new HashMap<>();
		map.put("Error",exception.getMessage());
		map.put("code", String.valueOf(HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	
	
}
