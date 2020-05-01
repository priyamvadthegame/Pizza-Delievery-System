package com.project.utils;

import com.project.entity.UserProfileEntity;
import com.project.json.UserProfileJson;

public class UserUtils {
	
	public static UserProfileEntity convertUserProfileJsonToUserProfileEntity(UserProfileJson userJson)
	{
		return new UserProfileEntity(userJson.getFirstname(), userJson.getLastname(), userJson.getDob(), userJson.getGender(),
			userJson.getStreet(), userJson.getLocation(), userJson.getCity(), userJson.getState(), userJson.getPincode(),
			userJson.getMobileno(), userJson.getEmailId(), userJson.getUser());
	}
	
	public static UserProfileJson convertUserProfileEntityToUserProfileJson(UserProfileEntity user)
	{
		return new UserProfileJson(user.getFirstname(), user.getLastname(), user.getDob(), user.getGender(),
			user.getStreet(), user.getLocation(), user.getCity(), user.getState(), user.getPincode(),
			user.getMobileno(), user.getEmailId(), user.getUser());
	}

}
