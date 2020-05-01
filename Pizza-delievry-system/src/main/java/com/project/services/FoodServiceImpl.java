package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.FoodEntity;
import com.project.json.Food;
import com.project.repositories.FoodRepository;
import com.project.utils.FoodUtils;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public boolean delete(String id) {
		
		return false;
	}

	@Override
	public Food save(Food food) {
	FoodEntity foodEntity=foodRepository.save(FoodUtils.convertFoodJsonToFoodEntity(food));
		return FoodUtils.convertFoodEntityToFoodJson(foodEntity);
	}

	@Override
	public Food update(Food food, String id) {
		FoodEntity foodEntity=foodRepository.findById(Long.valueOf(id)).get();
		if(foodEntity!=null) {
			foodEntity.
		}
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		List<FoodEntity> foodEntityList=foodRepository.findAll();
		return FoodUtils.convertFoodEntityListToFoodJson(foodEntityList);
	}

}
