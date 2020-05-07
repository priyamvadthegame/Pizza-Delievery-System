package com.project.services;


import com.project.json.UserJson;
import com.project.json.UserProfileJson;

public interface UserService {
	
	public UserProfileJson save(UserProfileJson user, String username, String password, String usertype);
	
	public String login(UserJson user);
	
	public UserProfileJson userInfo(String authToken);
	public UserProfileJson changepassword(String password,String newpassword, String id);
	public UserProfileJson update(UserProfileJson user, String id);
	
	public String logout(String authToken);


}
