package com.project.services;

import java.util.List;
import com.project.json.Food;

public interface FoodService {

	
	boolean delete(String id);
	Food save(Food food);
	Food update(Food food, String id);
	List<Food> getAllFood();

}
