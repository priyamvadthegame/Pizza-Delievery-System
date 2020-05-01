package com.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.json.StoreJson;

@Service
public class StoreServiceImpl implements StoreService{

	@Override
	public StoreJson save(StoreJson store) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStore(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StoreJson> filterStoreByFood(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreJson> getFoodInStore(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
