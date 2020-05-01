package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.FoodEntity;

public interface FoodRepository extends JpaRepository <FoodEntity, Long> {

	List<FoodEntity> findByName(String foodName);
	List<FoodEntity> findById(long id);
	List<FoodEntity> findByType(String foodType);
	List<FoodEntity> findBySize(String foodSize);
	
}
