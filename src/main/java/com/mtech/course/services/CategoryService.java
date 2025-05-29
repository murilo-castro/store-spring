package com.mtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtech.course.entities.Category;
import com.mtech.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	public CategoryRepository userRepository;
	
	public List<Category> findAll() {
		return userRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> category = userRepository.findById(id);
		
		return category.get();
	}
}
