package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.CreditCardJson;
import com.project.services.UserCreditCardServices;

@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins="*")
public class UserCreditCardController {
	
	
	@Autowired
	private UserCreditCardServices userCreditCardService;
	
	@RequestMapping(value="/user/creditcard",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CreditCardJson addCreditCard(@RequestBody CreditCardJson creditCardDetails,@RequestHeader(name = "authToken") String apiKey) {
		return userCreditCardService.save(creditCardDetails, apiKey);
	}
	
	@RequestMapping(value="/user/creditcard/verify",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public CreditCardJson verifyCreditCard(@RequestParam(name = "creditcardNumber") String creditCardNumber,@RequestHeader(name = "authToken") String apiKey) {
		return userCreditCardService.verify(creditCardNumber,apiKey);
	}
	
	@RequestMapping(value="/user/creditcard",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public CreditCardJson deleteCreditCard(@RequestParam(name = "creditcardNumber") String creditCardNumber,@RequestHeader(name = "authToken") String apiKey) {
		return userCreditCardService.delete(creditCardNumber,apiKey);
	}
	
	@RequestMapping(value="/user/creditcard",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CreditCardJson> getAllCreditCardOfAUser(@RequestHeader(name = "authToken") String apiKey) {
		return userCreditCardService.getAllCreditCards(apiKey);
	}
	
	

}
