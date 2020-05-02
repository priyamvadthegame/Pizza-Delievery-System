package com.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.project.entity.UserEntity;
import com.project.entity.UserProfileEntity;
import com.project.json.UserJson;
import com.project.json.UserProfileJson;

public class UserUtils {
	
	public static List<UserJson> convertUserEntityListToUserList(List<UserEntity> userEntityList) {
		List<UserJson> userList = new ArrayList<UserJson>();
		Consumer<UserEntity> consumer = (UserEntity userEntity)->userList.add(convertUserEntityToUser(userEntity));
		userEntityList.stream().forEach(consumer);
		return userList;
	}
	
	public static UserProfileJson convertUserEntityToUserProfileJson(UserProfileEntity userEntity) {
		return new UserProfileJson(userEntity.getUserId(),userEntity.getFirstname(), userEntity.getLastname(),userEntity.getDob(),userEntity.getGender(), userEntity.getStreet(),
				userEntity.getLocation(), userEntity.getCity(), userEntity.getState(), userEntity.getPincode(), userEntity.getMobileno(), userEntity.getEmailId());
	}

	public static UserProfileEntity convertUserToUserProfileEntity(UserProfileJson user) {
		return new UserProfileEntity(user.getFirstname(), user.getLastname(),user.getDob(),user.getGender(), user.getStreet(),
				user.getLocation(), user.getCity(), user.getState(), user.getPincode(), user.getMobileno(), user.getEmailId());
	}
	public static UserJson convertUserEntityToUser(UserEntity userEntity) {
		return new UserJson(userEntity.getUserId(), userEntity.getPassword(),userEntity.getUsertype(),userEntity.getLoginstatus(),
				userEntity.getSessionId());
		}

	public static UserEntity convertUserToUserEntity(UserJson user) {
		return new UserEntity(user.getPassword(),user.getUsertype(),user.getLoginstatus(),
				user.getSessionId());
		}


}
