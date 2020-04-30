package com.project.services;

import java.util.List;

import com.project.json.CreditCardJson;

public interface UserCreditCardService {
	
	public CreditCardJson save(CreditCardJson creditcardDetails,String sessionId);
	
	public CreditCardJson verify(String creditCardNumber,String sessionId);
	
	public CreditCardJson delete(String creditCardNumber,String sessionId);
	
	public List<CreditCardJson> getAllCreditCards(String sessionId);
	
	

}
