package com.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.FoodEntity;
import com.project.entity.StoreEntity;
import com.project.entity.UserEntity;
import com.project.entity.UserProfileEntity;
import com.project.json.Food;
import com.project.json.StoreJson;
import com.project.repositories.FoodRepository;
import com.project.repositories.StoreRepository;
import com.project.repositories.UserProfileRepository;
import com.project.repositories.UserRepository;
import com.project.utils.FoodUtils;

@Service
public class StoreServiceImpl implements StoreService{

	
	@Autowired
	private static UserRepository userRepository;
	@Autowired
	private static UserProfileRepository userProfieRepository;
	
	@Autowired
	private static FoodRepository foodRepository;
	@Autowired
	private static StoreRepository storeRepository;
	
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

	@Override
	public Food addFoodtoStore(long foodId, long storeId, String sessionId) {
		UserEntity userEntiy=getUserEntityBySessionId(sessionId);
		if(userEntiy!=null)
		{
			if(userEntiy.getUsertype().toLowerCase().contains("admin"))
			{	FoodEntity foodEntityToBeReturned=null;
				try
				{
					StoreEntity storeEntity=storeRepository.findById(foodId).get();
					FoodEntity foodEntity=foodRepository.findById(foodId).get();
					storeEntity.getFoodList().add(foodEntity);
					foodEntity.getStoreList().add(storeEntity);
					storeRepository.save(storeEntity);
					foodEntityToBeReturned=foodEntity;
				}
				catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				return FoodUtils.convertFoodEntityToFoodJson(foodEntityToBeReturned);
			}
			else
			{
				return new Food(0,"You cannot add food as you are not an admin please have an admin access to continue","","",0,0.0);		
			}
		}
	
		else
		{
			return new Food(0,"Please login to continue","","",0,0.0);
		}
	}
	
	@Override
	public List<Food> deleteFoodFromStore(long foodId, long storeId, String sessionId) {
		UserEntity userEntiy=getUserEntityBySessionId(sessionId);
		if(userEntiy!=null)
		{
			if(userEntiy.getUsertype().toLowerCase().contains("admin"))
			{	
				StoreEntity storeEntityToBeReturned=null;
				try
				{
					StoreEntity storeEntity=storeRepository.findById(foodId).get();
					FoodEntity foodEntity=foodRepository.findById(foodId).get();
					storeEntity.getFoodList().remove(foodEntity);
					foodEntity.getStoreList().remove(storeEntity);
					storeRepository.save(storeEntity);
					
					storeEntityToBeReturned=storeEntity;
				}
				catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				List<Food> returnList=new ArrayList<Food>();
				storeEntityToBeReturned.getFoodList().stream().forEach(food->returnList.add(FoodUtils.convertFoodEntityToFoodJson(food)));
				return returnList ;
			}
			else
			{	List<Food> errorList=new ArrayList<Food>();
				 errorList.add(new Food(0,"You cannot add food as you are not an admin please have an admin access to continue","","",0,0.0));
				 return errorList;
			}
		}
	
		else
		{	
			List<Food> errorList=new ArrayList<Food>();
			errorList.add(new Food(0,"Please login to continue","","",0,0.0));
			return errorList;
			
		}
	}
	
	
	public static  UserEntity getUserEntityBySessionId(String sessionId)
	{
		List<UserEntity> userEntity=userRepository.findByLoginStatus(sessionId);
		
		if(userEntity!=null&&userEntity.size()>0)
		{
			return userEntity.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public static UserProfileEntity getUserProfileEntityById(Long userId)
	{
		List<UserProfileEntity> userProfileEntityList=userProfieRepository.findByUserId(userId);
		if(userProfileEntityList!=null&&userProfileEntityList.size()>0)
		{
			return userProfileEntityList.get(0);
		}
		else
		{
			return null;
		}
	}

}
