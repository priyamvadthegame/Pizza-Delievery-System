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
		if(userRepository.findByUsername(username).size()==0)
		{
			UserEntity newUser = new UserEntity();
			newUser.setUsername(username);
			newUser.setPassword(password);
			newUser.setUsertype(usertype);
			userRepository.save(newUser);
			UserProfileEntity userProfileEntity = UserUtils.convertUserProfileJsonToUserProfileEntity(user);
			userProfileEntity.setUser(newUser);
			UserProfileEntity userprofileEntity = userprofileRepository.save(userProfileEntity);
			newUser.setUserprofile(userprofileEntity);
			userRepository.save(newUser);
			return UserUtils.convertUserProfileEntityToUserProfileJson(userprofileEntity);
		}
		else
		{
			return new UserProfileJson("Username already exists..Please enter another Username", null , null , null , null , null, 
					null, null, null, null, null);
		}
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
			return "{ \"result\": \"failed\", \"message\": \"Invalid user " + username + "\"}";
		}
		else
		{
			UserEntity userEntity = userList.get(0);
			if(password.equals(userEntity.getPassword()))
			{
				loginStatus = Integer.toString(random.nextInt(500000));
				userEntity.setLoginStatus(loginStatus);
				userEntity=userRepository.save(userEntity);
				return "{ \"result\": \"success\", \"message\": \"Login successful\", \"authtoken\":\"" + loginStatus +"\",\"usertype\":\""+userEntity.getUsertype()+"\"}";	
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
			return UserUtils.convertUserProfileEntityToUserProfileJson(userEntity.getUserprofile());
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
	public UserProfileJson update(UserProfileJson user, String id) {
		
		UserEntity userEntity=userRepository.findByLoginStatus(id).get(0);
		UserProfileEntity userProfileEntity =userEntity.getUserprofile();
		if(userEntity != null) {
			userProfileEntity.setUserId(userProfileEntity.getUserId());
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
			userProfileEntity = userprofileRepository.save(userProfileEntity);
			return UserUtils.convertUserProfileEntityToUserProfileJson(userProfileEntity);
		}
		return null;
	}
	
	@Override
	public UserProfileJson changepassword(String password,String newpassword, String id) {
		UserEntity userEntity = userRepository.findByLoginStatus(id).get(0);
		if(userEntity != null) {
					if(password.equals(userEntity.getPassword())) {
				
				userEntity.setPassword(newpassword);
				userEntity = userRepository.save(userEntity);
				return UserUtils.convertUserProfileEntityToUserProfileJson(userEntity.getUserprofile());	
				}
				else {
					return null;
				}
		}
		return null;
	}

}
