package com.project.services;

import java.util.List;


import com.project.json.StoreJson;

public interface StoreService {
	
	
	public  StoreJson save(StoreJson store) ;
	
	
	public boolean deleteStore( Long id);
	
	
	public List<StoreJson> filterStoreByFood( Long id);
	
	public List<StoreJson> getFoodInStore( Long id);
	
}
