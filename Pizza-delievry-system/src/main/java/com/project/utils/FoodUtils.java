package com.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.project.entity.FoodEntity;
import com.project.json.Food;

public class FoodUtils {

	public static List<Food> convertFoodEntityListToFoodJson(List<FoodEntity> foodEntityList)
	{
		List<Food> fdList=new ArrayList<Food>();
		Consumer<FoodEntity> consumer=(FoodEntity fd)->fdList.add(convertFoodEntityToFoodJson(fd));
		foodEntityList.stream().forEach(consumer);
		return fdList;
	}
	
	public static Food convertFoodEntityToFoodJson(FoodEntity foodEntity)
	{
		return new Food(foodEntity.getId(),foodEntity.getFoodName(),foodEntity.getFoodType(),foodEntity.getFoodSize(),
				foodEntity.getQuantity(),foodEntity.getPrice());
	}
	
	public static FoodEntity convertFoodJsonToFoodEntity(Food food)
	{
		return new FoodEntity(food.getId(),food.getFoodName(),food.getFoodType(),food.getFoodSize(),
				food.getQuantity(),food.getPrice());
	}



}
