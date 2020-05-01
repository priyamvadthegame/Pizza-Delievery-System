package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.OrderEntity;

@Component
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	}
