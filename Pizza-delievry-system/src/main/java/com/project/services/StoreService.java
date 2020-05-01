package com.project.services;

import java.util.List;

import com.project.json.Food;
import com.project.json.Store;

public interface StoreService {
	public Store registerStore(Store store);
	public boolean deleteStore(Long id);
	public List<Store> filterStoreByFood(Long id);
	public List<Food> getFoodInStore(Long id);
	public Store save(Store store);
	
	

}
