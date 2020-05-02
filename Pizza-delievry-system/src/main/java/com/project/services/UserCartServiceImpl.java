package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartEntity;
import com.project.entity.UserEntity;
import com.project.json.CartJson;
import com.project.json.UserJson;
import com.project.json.UserProfileJson;
import com.project.repositories.UserCartRepository;
import com.project.repositories.UserRepository;
import com.project.utils.UserCartUtils;



@Service
public class UserCartServiceImpl implements UserCartService {

	@Autowired
	private UserCartRepository cartRepository;

	@Override
	public CartJson additems(CartJson cart, String cartid) {
		List<UserCartRepository> cartEntity=cartRepository.findBySessionId(cartid); 
		if(cartEntity!=null)
		{	
			CartEntity cartToPersist=UserCartUtils.convertCartJsonToCartEntity(cart);

			
			return UserCartUtils.convertCartEntityToCartJson(cartToPersist);
		}
		else
		{
			return null;
		}
	}
		
}

