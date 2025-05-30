package com.mtech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtech.course.entities.OrderItem;
import com.mtech.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>  {

}
