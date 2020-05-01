package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.UserJson;
import com.project.json.UserProfileJson;
import com.project.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/user", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserProfileJson registerUser(@RequestBody UserProfileJson user) {
		return userService.save(user);
	}
	
	@PostMapping(value="/user/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestBody UserJson user) {
		return userService.login(user);
	}
	
	@GetMapping(value="/user/profile", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserProfileJson userInfo(@RequestHeader(name="auth-token") String authToken) {
		return userService.userInfo(authToken);
	}
	
	@PutMapping(value="/user/logout", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logoutUser(@RequestHeader(name="auth-token") String authToken) {
		return userService.logout(authToken);
	}

}
