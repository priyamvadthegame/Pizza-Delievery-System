package com.project.services;

import java.util.List;


import com.project.json.Food;
import org.springframework.stereotype.Service;

import com.project.json.Food;





public interface FoodService {

	public boolean delete(Long id,String sessionId);
	public Food save(Food food,String id);
	public Food update(Food food, String id);
	public List<Food> getAllFood();
	public List<Food> sortFoodByPrice();
	public List<Food> filterFoodBySearchText(String searchtext);
	public List<Food> filterFoodByType(String type);


}
