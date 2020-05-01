package com.project.utils;

import com.project.entity.UserEntity;
import com.project.entity.UserProfileEntity;
import com.project.json.UserJson;
import com.project.json.UserProfileJson;

public class UserUtils {
	
	public static UserProfileEntity convertUserProfileJsonToUserProfileEntity(UserProfileJson userprofileJson)
	{
		return new UserProfileEntity(userprofileJson.getFirstname(), userprofileJson.getLastname(), userprofileJson.getDob(), userprofileJson.getGender(),
			userprofileJson.getStreet(), userprofileJson.getLocation(), userprofileJson.getCity(), userprofileJson.getState(), userprofileJson.getPincode(),
			userprofileJson.getMobileno(), userprofileJson.getEmailId());
	}
	
	public static UserProfileJson convertUserProfileEntityToUserProfileJson(UserProfileEntity userprofileEntity)
	{
		return new UserProfileJson(userprofileEntity.getFirstname(), userprofileEntity.getLastname(), userprofileEntity.getDob(), userprofileEntity.getGender(),
			userprofileEntity.getStreet(), userprofileEntity.getLocation(), userprofileEntity.getCity(), userprofileEntity.getState(), userprofileEntity.getPincode(),
			userprofileEntity.getMobileno(), userprofileEntity.getEmailId());
	}
	
	public static UserEntity convertUserJsonToUserEntity(UserJson userJson)
	{
		return new UserEntity(userJson.getUsername(), userJson.getPassword(), userJson.getUsertype(), userJson.getLoginstatus());
		
	}
	
	public static UserJson convertUserEntityToUserJson(UserEntity userEntity)
	{
		return new UserJson(userEntity.getUsername(), userEntity.getPassword(), userEntity.getUsertype(), userEntity.getLoginStatus());
		
	}
	
	

}
