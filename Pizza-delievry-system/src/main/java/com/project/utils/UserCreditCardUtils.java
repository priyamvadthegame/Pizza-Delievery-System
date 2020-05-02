package com.project.utils;


import java.util.ArrayList;
import java.util.List;

import com.project.entity.CreditCardEntity;
import com.project.json.CreditCardJson;

public class UserCreditCardUtils {
	
	public static CreditCardEntity convertCreditCardJsontoEntity(CreditCardJson creditcard)
	{
		return new CreditCardEntity(creditcard.getCreditCardNumber(),creditcard.getValidFrom(),creditcard.getValidTo(),creditcard.getBalance());
	}
	
	public static CreditCardJson convertCreditCardEntitytoJson(CreditCardEntity creditcard)
	{
		return new CreditCardJson(creditcard.getCreditCardNumber(),creditcard.getValidFrom(),creditcard.getValidTo(),creditcard.getBalance());
	}
	
	public static List<CreditCardJson> convertCreditCardEntityListtoJsonList(List<CreditCardEntity> creditcardList)
	{	List<CreditCardJson> creditcardJsonList=new ArrayList<>();
		 creditcardList.stream().forEach((creditCard)->creditcardJsonList.add(convertCreditCardEntitytoJson(creditCard)));
		 
		 return creditcardJsonList;
	}
}
