package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.entity.FoodEntity;
import com.project.entity.UserEntity;
import com.project.json.Food;
import com.project.repositories.FoodRepository;
import com.project.repositories.UserRepository;
import com.project.utils.FoodUtils;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean delete(String id) {
		List<UserEntity> userEntity=userRepository.findByLoginstatus(id);
		
		if(foodRepository.existsById(Long.valueOf(id)))
		{
			foodRepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

	@Override
	public Food save(Food food,String id) {
		List<UserEntity> userEntity=userRepository.findByLoginstatus(id);
		
	FoodEntity foodEntity=foodRepository.save(FoodUtils.convertFoodJsonToFoodEntity(food));
		return FoodUtils.convertFoodEntityToFoodJson(foodEntity);
	}

	@Override
	public Food update(Food food, String id) {
		List<UserEntity> userEntity=userRepository.findByLoginstatus(id);
		FoodEntity foodEntity=foodRepository.findById(Long.valueOf(id)).get();
		if(foodEntity!=null) {
			foodEntity.setFoodName(foodEntity.getFoodName());
			foodEntity.setFoodType(foodEntity.getFoodType());
			foodEntity.setFoodSize(foodEntity.getFoodSize());
			foodEntity.setQuantity(foodEntity.getQuantity());
			foodEntity.setPrice(foodEntity.getPrice());
			foodEntity.setCartList(foodEntity.getCartList());
			return FoodUtils.convertFoodEntityToFoodJson(foodEntity);
			
		}
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		List<FoodEntity> foodEntityList=foodRepository.findAll();
		return FoodUtils.convertFoodEntityListToFoodJson(foodEntityList);
	}
}

