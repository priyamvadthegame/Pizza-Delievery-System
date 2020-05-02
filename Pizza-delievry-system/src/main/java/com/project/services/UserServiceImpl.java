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
	
	public UserProfileJson save(UserProfileJson user, String username, String password, String usertype)
	{
		UserEntity newUser = new UserEntity(username, password, usertype);
		UserProfileEntity userprofileEntity = userprofileRepository.findByUserId(newUser.getUserId()).get(0);
		userprofileEntity = userprofileRepository.save(UserUtils.convertUserProfileJsonToUserProfileEntity(user));
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
		List<UserEntity> userList = userRepository.findByLoginStatus(authToken);
		if (authToken.equals(null) || userList == null || userList.size() == 0)
		{
			return null;
		}
		else
		{
			UserEntity userEntity = userRepository.findByLoginStatus(authToken).get(0);
			UserProfileEntity userprofileEntity = userprofileRepository.findByUserId(userEntity.getUserId()).get(0);
			return UserUtils.convertUserProfileEntityToUserProfileJson(userprofileEntity);
		}
	}
	
	public String logout(String authToken)
	{
		List<UserEntity> userList = userRepository.findByLoginStatus(authToken);
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
	
	@Override
	public UserProfileJson update(UserProfileJson user, long id) {
		UserProfileEntity userProfileEntity = userprofileRepository.findByUserId(id).get(0);
		if(userProfileEntity != null) {
			userProfileEntity.setUserId(user.getUserId());
			userProfileEntity.setFirstname(user.getFirstname());
			userProfileEntity.setLastname(user.getLastname());
			userProfileEntity.setDob(user.getDob());
			userProfileEntity.setGender(user.getGender());
			userProfileEntity.setStreet(user.getStreet());
			userProfileEntity.setLocation(user.getLocation());
			userProfileEntity.setCity(user.getCity());
			userProfileEntity.setState(user.getState());
			userProfileEntity.setPincode(user.getPincode());
			userProfileEntity.setMobileno(user.getMobileno());
			userProfileEntity.setEmailId(user.getEmailId());

			//userProfileEntity.setPassword(user.getPassword());
			userProfileEntity = userprofileRepository.save(userProfileEntity);
			return UserUtils.convertUserProfileEntityToUserProfileJson(userProfileEntity);
		}
		return null;
	}
	
	@Override
	public UserJson changepassword(UserJson user, String id) {
		String password = user.getPassword();
		UserEntity userEntity = userRepository.findById(Long.valueOf(id)).get();
		if(userEntity != null) {
					if(password.equals(user.getPassword())) {
				
				userEntity.setPassword(user.getPassword());
				userEntity = userRepository.save(userEntity);
				return UserUtils.convertUserEntityToUserJson(userEntity);	
				}
				else {
					return null;
				}
		}
		return null;
	}

}
