package com.mtech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtech.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
