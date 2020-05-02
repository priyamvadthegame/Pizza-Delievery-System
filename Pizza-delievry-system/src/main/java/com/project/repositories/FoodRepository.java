package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

import com.project.entity.FoodEntity;
@Component
public interface FoodRepository extends JpaRepository <FoodEntity, Long> {

	List<FoodEntity> findByFoodName(String foodName);
	List<FoodEntity> findByFoodType(String foodType);
	List<FoodEntity> findByFoodSize(String foodSize);
}

	

