package com.mtech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtech.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
