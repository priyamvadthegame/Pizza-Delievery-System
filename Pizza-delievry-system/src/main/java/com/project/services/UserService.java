package com.project.services;

import java.util.List;
import com.project.json.UserJson;
import com.project.json.UserProfileJson;

public interface UserService {
	
	public UserJson changepassword(UserJson user, String id);
	public UserProfileJson update(UserProfileJson user, long id);



}
