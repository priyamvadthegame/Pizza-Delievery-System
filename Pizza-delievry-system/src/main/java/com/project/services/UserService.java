package com.project.services;

import com.project.json.UserJson;
import com.project.json.UserProfileJson;

public interface UserService {
	
	public UserProfileJson save(UserProfileJson user);
	
	public String login(UserJson user);
	
	public UserProfileJson userInfo(String authToken);
	
	public String logout(String authToken);

}
