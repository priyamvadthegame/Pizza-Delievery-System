package com.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.json.Food;
@Service
public interface FoodService {

	
	boolean delete(String id);
	Food save(Food food);
	Food update(Food food, String id);
	List<Food> getAllFood();

}
