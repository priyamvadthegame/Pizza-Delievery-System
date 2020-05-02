package com.project.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import com.project.entity.StoreEntity;

import com.project.json.StoreJson;

public class StoreUtils {

	public static List<StoreJson> convertStoreEntityListToStoreJson(List<StoreEntity> storeEntityList)
	{
		List<StoreJson> stList=new ArrayList<StoreJson>();
		Consumer<StoreEntity> consumer=(StoreEntity st)->stList.add(convertStoreEntityToStoreJson(st));
		storeEntityList.stream().forEach(consumer);
		return stList;
	}
	
	public static StoreJson convertStoreEntityToStoreJson(StoreEntity storeEntity)
	{
		return new StoreJson(storeEntity.getStoreName(),storeEntity.getStoreStreet(),storeEntity.getStoreMobileNo(),storeEntity.getStoreCity(),storeEntity.getStoreState(),storeEntity.getStorePincode());
	}
	
	public static StoreEntity convertStoreJsonToStoreEntity(StoreJson store)
	{
		return new StoreEntity(store.getStoreName(),store.getStoreStreet(),store.getStoreMobileNo(),store.getStoreCity(),store.getStoreState(),store.getStorePincode());
	}

}
