package com.mtech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtech.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>  {

}
