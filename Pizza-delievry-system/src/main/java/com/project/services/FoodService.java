package com.project.services;

import java.util.List;

import com.project.json.Food;



import org.springframework.stereotype.Service;

import com.project.json.Food;
@Service

public interface FoodService {

	
<<<<<<< HEAD
	boolean delete(String id);
	Food save(Food food,String id);
	Food update(Food food, String id);
	List<Food> getAllFood();
=======
	public boolean delete(String id);
	public Food save(Food food);
	public Food update(Food food, String id);
	public List<Food> getAllFood();
	public List<Food> sortFoodByPrice();
	public List<Food> filterFoodBySearchText(String searchtext);
	public List<Food> filterFoodByType(String type);
>>>>>>> branch 'master' of https://github.com/priyamvadthegame/Pizza-Delievery-System.git

}
