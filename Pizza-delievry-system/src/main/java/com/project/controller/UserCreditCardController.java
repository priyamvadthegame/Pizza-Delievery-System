package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.CreditCardJson;
import com.project.services.UserCreditCardService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserCreditCardController {
	
	
	@Autowired
	private UserCreditCardService userCreditCardService;
	
	@RequestMapping(value="/creditcard",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CreditCardJson addCreditCard(@RequestBody CreditCardJson creditCardDetails,@RequestHeader String apiKey) {
		return userCreditCardService.save(creditCardDetails, apiKey);
	}
	
	@RequestMapping(value="/creditcard/verify",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public CreditCardJson verifyCreditCard(@RequestHeader String creditCardNumber,@RequestHeader String apiKey) {
		return userCreditCardService.verify(creditCardNumber,apiKey);
	}
	
	@RequestMapping(value="/creditcard/verify",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public CreditCardJson deleteCreditCard(@RequestHeader String creditCardNumber,@RequestHeader String apiKey) {
		return userCreditCardService.delete(creditCardNumber,apiKey);
	}
	
	@RequestMapping(value="/creditcard/verify",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CreditCardJson> getAllCreditCardOfAUser(@RequestHeader String apiKey) {
		return userCreditCardService.getAllCreditCards(apiKey);
	}
	
	

}
