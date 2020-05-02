package com.project.services;


import com.project.json.UserJson;
import com.project.json.UserProfileJson;

public interface UserService {
	
	public UserProfileJson save(UserProfileJson user, String username, String password, String usertype);
	
	public String login(UserJson user);
	
	public UserProfileJson userInfo(String authToken);
	public UserJson changepassword(UserJson user, String id);
	public UserProfileJson update(UserProfileJson user, long id);
	
	public String logout(String authToken);


}
