package com.mtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtech.course.entities.Product;
import com.mtech.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		
		return product.get();
	}
}
