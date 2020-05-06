package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.CartJson;
import com.project.services.UserCartService;

@RestController
@RequestMapping("/cart")
public class UserCartController {
	
	@Autowired
	private UserCartService registrationService;


	@PostMapping(value="/add", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CartJson registerUser(@RequestBody CartJson cart,@RequestHeader String sid,@RequestParam String cartid) {

		return registrationService.additems(cart,sid,cartid);
	}
	@DeleteMapping(value="/delete")
	public CartJson deleteUser(@RequestHeader(value="id") String id,@RequestParam long cartid,@RequestParam String foodid) {
		return registrationService.delete(id,cartid,foodid);
	}

	


}
