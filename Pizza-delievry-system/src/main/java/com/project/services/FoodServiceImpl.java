package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.json.Food;
import com.project.repositories.FoodRepository;

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
		// TODO Auto-generated method stub
		return null;
	}

}
