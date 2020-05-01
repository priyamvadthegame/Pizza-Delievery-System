package com.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.project.entity.FoodEntity;
import com.project.entity.StoreEntity;
import com.project.json.Food;
import com.project.json.Store;

public class StoreUtils {

	public static List<Store> convertStoreEntityListToStoreJson(List<StoreEntity> storeEntityList)
	{
		List<Store> stList=new ArrayList<Store>();
		Consumer<StoreEntity> consumer=(StoreEntity st)->stList.add(convertStoreEntityToStoreJson(st));
		storeEntityList.stream().forEach(consumer);
		return stList;
	}
	
	public static Store convertStoreEntityToStoreJson(StoreEntity storeEntity)
	{
		return new Store(storeEntity.getStoreName(),storeEntity.getStoreStreet(),storeEntity.getStoreMobileNo(),storeEntity.getStoreCity(),storeEntity.getStoreState(),storeEntity.getStorePincode());
	}
	
	public static StoreEntity convertStoreJsonToStoreEntity(Store store)
	{
		return new StoreEntity(store.getStoreName(),store.getStoreStreet(),store.getStoreMobileNo(),store.getStoreCity(),store.getStoreState(),store.getStorePincode());
	}

}
