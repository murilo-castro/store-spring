package com.mtech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtech.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
