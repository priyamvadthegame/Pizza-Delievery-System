package com.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.FoodEntity;
import com.project.json.Food;
import com.project.json.StoreJson;

public interface StoreService {
	
	
	public  StoreJson save(StoreJson store) ;
	
	
	public boolean deleteStore( Long id);
	
	
	public Food addFoodtoStore(long foodId,long storeId,String sessionId);
	
	public List<Food> deleteFoodFromStore(long foodId, long storeId, String sessionId);
	
	
	public List<StoreJson> filterStoreByFood( Long id);
	
	public List<StoreJson> getFoodInStore( Long id);
	
	
	
}
