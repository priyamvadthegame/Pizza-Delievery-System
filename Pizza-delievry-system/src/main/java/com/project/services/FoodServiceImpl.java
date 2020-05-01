package com.project.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food update(Food food, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		List<FoodEntity> foodEntityList = foodRepository.findAll();
		return FoodUtils.convertFoodEntityListToFoodJson(foodEntityList);
	}

	@Override
	public List<Food> sortFoodByPrice() {
		Comparator<Food> comparefoodprice = Comparator.comparing(Food::getPrice);
		return getAllFood().stream().sorted(comparefoodprice).collect(Collectors.toList());
	}

	@Override
	public List<Food> filterFoodBySearchText(String searchtext) {
		
		Optional<Food> option=getAllFood().stream().filter((Food fd)->
		fd.getFoodName().contains(searchtext)||fd.getFoodType().contains(searchtext)).findAny();
		if(option.isPresent()) 
		{
			return getAllFood().stream().filter((Food fd)->fd.getFoodName().contains(searchtext)||
					fd.getFoodType().contains(searchtext)).collect(Collectors.toList());
		}
		else 
		{
			return null;
		}
	}

	@Override
	public List<Food> filterFoodByType(String type) {
		
		Optional<Food> option=getAllFood().stream().filter((Food fd)->
		fd.getFoodType().toLowerCase().equals(type.toLowerCase())).findAny();
		if(option.isPresent())
		{
			return getAllFood().stream().filter((Food fd)->
			fd.getFoodType().toLowerCase().equals(type.toLowerCase())).collect(Collectors.toList());
		}
		else
		{
			return null;
		}
	}

}
