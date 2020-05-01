package com.project.services;

import java.util.List;

import com.project.json.Food;



import org.springframework.stereotype.Service;

import com.project.json.Food;
@Service

public interface FoodService {

	
	boolean delete(String id);
	Food save(Food food,String id);
	Food update(Food food, String id);
	List<Food> getAllFood();

}
