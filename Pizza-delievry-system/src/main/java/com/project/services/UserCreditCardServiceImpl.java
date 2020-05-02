package com.project.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CreditCardEntity;
import com.project.entity.UserEntity;
import com.project.entity.UserProfileEntity;
import com.project.json.CreditCardJson;
import com.project.repositories.UserCreditCardRepository;
import com.project.repositories.UserProfileRepository;
import com.project.repositories.UserRepository;
import com.project.utils.UserCreditCardUtils;

@Service
public class UserCreditCardServiceImpl implements UserCreditCardServices {

	@Autowired
	private static UserRepository userRepository;
	
	@Autowired
	private static UserProfileRepository userProfileRepository;
	
	@Autowired
	private static UserCreditCardRepository userCreditCardRepository;
	
	@Override
	public CreditCardJson save(CreditCardJson creditcardDetails, String sessionId) {
		UserEntity userEntity=getUserEntityBySessionId(sessionId);
		if(userEntity!=null)
		{
				CreditCardEntity creditCardEntity=UserCreditCardUtils.convertCreditCardJsontoEntity(creditcardDetails);
				creditCardEntity.setUserId(userEntity);
				userCreditCardRepository.save(creditCardEntity);
				return creditcardDetails;
		}
		else
		{
			return new CreditCardJson(0L,"Your session has expired please Re login and try again","",0.0);
		}
		
		
	}

	@Override
	public CreditCardJson verify(String creditCardNumber, String sessionId) {
		UserEntity userEntity=getUserEntityBySessionId(sessionId);
		if(userEntity!=null)
		{	
			List<CreditCardEntity> creditCardList=userEntity.getCards();
			if(creditCardList.stream().filter((creditCard)->creditCard.getCreditCardNumber().equals(creditCardNumber)).findAny().isPresent())
			{
				return UserCreditCardUtils.convertCreditCardEntitytoJson(creditCardList.stream().filter((creditCard)->creditCard.getCreditCardNumber().equals(creditCardNumber)).collect(Collectors.toList()).get(0));
			}
			else
			{
				return  new CreditCardJson(0L,"Sorry Wrong credential please try again","",0.0);
			}
		}
		else
		{
			return new CreditCardJson(0L,"Your session has expired please Re login and try again","",0.0);
		}
	}

	@Override
	public CreditCardJson delete(String creditCardNumber, String sessionId) {
		UserEntity userEntity=getUserEntityBySessionId(sessionId);
		if(userEntity!=null)
		{	
			List<CreditCardEntity> creditCardList=userEntity.getCards();
			if(creditCardList.stream().filter((creditCard)->creditCard.getCreditCardNumber().equals(creditCardNumber)).findAny().isPresent())
			{
				CreditCardEntity creditCardToBeDeleted= creditCardList.stream().filter((creditCard)->creditCard.getCreditCardNumber().equals(creditCardNumber)).collect(Collectors.toList()).get(0);
				userCreditCardRepository.delete(creditCardToBeDeleted);
				return new CreditCardJson(0L,"Credit Card Deleted Successfully","",0.0) ;
			}
			else
			{
				return  new CreditCardJson(0L,"Sorry Wrong credential please try again","",0.0);
			}
		}
		else
		{
			return new  CreditCardJson(0L,"Your session has expired please Re login and try again","",0.0);
		}
	}

	@Override
	public List<CreditCardJson> getAllCreditCards(String sessionId) {
		UserEntity userEntity=getUserEntityBySessionId(sessionId);
		if(userEntity!=null)
		{	
			List<CreditCardEntity> creditCardList=userEntity.getCards();
			return UserCreditCardUtils.convertCreditCardEntityListtoJsonList(creditCardList);
		}
		
		else
		{
			List<CreditCardJson> errorList=new ArrayList<>();
			errorList.add( new CreditCardJson(0L,"Your session has expired please Re login and try again","",0.0));
			return errorList;
		}
	}
	
	
	public static UserProfileEntity getUserProfileEntityById(Long userId)
	{
		List<UserProfileEntity> userProfileEntityList=userProfileRepository.findByUserId(userId);
		if(userProfileEntityList!=null&&userProfileEntityList.size()>0)
		{
			return userProfileEntityList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	
	public static  UserEntity getUserEntityBySessionId(String sessionId)
	{
		List<UserEntity> userEntity=userRepository.findByLoginStatus(sessionId);
		
		if(userEntity!=null&&userEntity.size()>0)
		{
			return userEntity.get(0);
		}
		else
		{
			return null;
		}
	}

}
