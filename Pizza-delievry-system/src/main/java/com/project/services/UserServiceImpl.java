package com.project.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.UserEntity;
import com.project.entity.UserProfileEntity;
import com.project.json.UserJson;
import com.project.json.UserProfileJson;
import com.project.repositories.UserRepository;
import com.project.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserProfileJson save(UserProfileJson user)
	{
		UserProfileEntity userprofileEntity = userRepository.save(UserUtils.convertUserProfileJsonToUserProfileEntity(user));
		return UserUtils.convertUserProfileEntityToUserProfileJson(userprofileEntity);
	}
	
	public String login(UserJson user)
	{
		String sessionId = null;
		Random random = new Random();
		UserJson newUser = UserUtils.convertUserEntitytoUserJson(userRepository.findByUserId(user.getUserId()));
		if(newUser.getUserId() == user.getUserId())
		{
			if(newUser.getPassword().equals(user.getPassword()))
			{
				sessionId = Integer.toString(random.nextInt(500000));
				UserEntity userEntity = userRepository.findByUserId(Long.valueOf(newUser.getUserId()));
				
			}
		}
	}
	
	public UserProfileJson userInfo(String authToken)
	{
		
		return UserUtils.convertUserProfileEntityToUserProfileJson(userEntity);	
	}
	
	public String logout(String authToken)
	{
		if (authToken.equals(null))
		{
			return "{\"result\": \"Invalid SessionId\"}";
		}
		else
		{
			userRepository.deleteBySessionId(authToken);
			return "{\"result\": \"Sucess\"}";
		}
		
	}
	
	
}
