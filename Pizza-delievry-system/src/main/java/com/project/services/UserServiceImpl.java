package com.project.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.UserEntity;
import com.project.entity.UserProfileEntity;
import com.project.json.UserJson;
import com.project.json.UserProfileJson;
import com.project.repositories.UserProfileRepository;
import com.project.repositories.UserRepository;
import com.project.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userprofileRepository;
	
	public UserProfileJson save(UserProfileJson user)
	{
		UserProfileEntity userprofileEntity = userprofileRepository.save(UserUtils.convertUserProfileJsonToUserProfileEntity(user));
		return UserUtils.convertUserProfileEntityToUserProfileJson(userprofileEntity);
	}
	
	public String login(UserJson user)
	{
		String loginStatus = null;
		Random random = new Random();
		String username = user.getUsername();
		String password = user.getPassword();
		List<UserEntity> userList = userRepository.findByUsername(username);
		if(userList == null || userList.size() == 0)
		{
			return "{ \"result\": \"failed\", \"message\": \"Invalid user\" " + username + "}";
		}
		else
		{
			UserEntity userEntity = userList.get(0);
			if(password.equals(userEntity.getPassword()))
			{
				loginStatus = Integer.toString(random.nextInt(500000));
				userEntity.setLoginStatus(loginStatus);
				userRepository.save(userEntity);
				return "{ \"result\": \"success\", \"message\": \"Login successful\", \"auth-token\":\"" + loginStatus + "\"}";	
			}
			else
			{
				return "{ \"result\": \"failed\", \"message\": \"Invalid password\" }";
			}
		}
		
	}
	
	public UserProfileJson userInfo(String authToken)
	{
		UserEntity userEntity = userRepository.findByLoginstatus(authToken).get(0);
		UserProfileEntity userprofileEntity = userprofileRepository.findByUserId(userEntity.getUserId()).get(0);
		return UserUtils.convertUserProfileEntityToUserProfileJson(userprofileEntity);
	}
	
	public String logout(String authToken)
	{
		List<UserEntity> userList = userRepository.findByLoginstatus(authToken);
		if (authToken.equals(null) || userList == null || userList.size() == 0)
		{
			return "{\"result\": \"Invalid LoginStatus\"}";
		}
		else
		{
			UserEntity userEntity = userList.get(0);
			userEntity.setLoginStatus(null);
			userEntity = userRepository.save(userEntity);
			return "{\"result\": \"Logout Successful\"}";
		}
		
	}

}
