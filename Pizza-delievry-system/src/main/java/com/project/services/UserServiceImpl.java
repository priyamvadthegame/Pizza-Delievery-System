package com.project.services;

import java.util.List;

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


	public UserJson save(UserJson user) {
		UserEntity userEntity = 
				userRepository.save(UserUtils.convertUserToUserEntity(user));
		return UserUtils.convertUserEntityToUser(userEntity);
	}
	
	public UserProfileJson save(UserProfileJson user) {
		UserProfileEntity userProfileEntity = 
				userRepository.save(UserUtils.convertUserToUserProfileEntity(user));
		return UserUtils.convertUserEntityToUserProfileJson(userProfileEntity);
	}
	@Override
	public UserProfileJson update(UserProfileJson user, long id) {
		UserProfileEntity userProfileEntity = userRepository.findByuserId(id).get(0);
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
			userProfileEntity = userRepository.save(userProfileEntity);
			return UserUtils.convertUserEntityToUserProfileJson(userProfileEntity);
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
				return UserUtils.convertUserEntityToUser(userEntity);	
				}
				else {
					return null;
				}
		}
		return null;
	}
	
	
	
	


}
