package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartEntity;
import com.project.entity.FoodEntity;
import com.project.entity.UserEntity;
import com.project.json.CartJson;
import com.project.json.UserJson;
import com.project.json.UserProfileJson;
import com.project.repositories.FoodRepository;
import com.project.repositories.UserCartRepository;
import com.project.repositories.UserRepository;
import com.project.utils.UserCartUtils;



@Service
public class UserCartServiceImpl implements UserCartService {

	@Autowired
	private UserCartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FoodRepository foodRepository;

	@Override
	public CartJson additems(CartJson cart,String sessionid, String cartid) {
		List<UserEntity> userEntitylist=userRepository.findByLoginStatus(sessionid); 
		if(userEntitylist!=null&&userEntitylist.size()>0)
		{	
			UserEntity userEntity=userEntitylist.get(0);
			CartEntity cartToPersist=UserCartUtils.convertCartJsonToCartEntity(cart);
			cartToPersist.setUser(userEntity);
			cartToPersist=cartRepository.save(cartToPersist);
			return UserCartUtils.convertCartEntityToCartJson(cartToPersist);
		}
		else
		{
			return new CartJson(0, 0, "please login to continue", 0, 0, null, null);
		}
	}

	@Override
	public CartJson delete(String id, long cartid, String foodid) {
		List<UserEntity> userEntitylist=userRepository.findByLoginStatus(id); 
		if(userEntitylist!=null&&userEntitylist.size()>0)
		{		
			List<CartEntity> cartEntitylist=cartRepository.findByCartId(cartid); 
			if(cartEntitylist!=null)
			{			
				List<FoodEntity> foodEntitylist=foodRepository.findByFoodId(cartid); 
				if(cartEntitylist.get(0).getFoodlist().contains(foodEntitylist.get(0)))
				{	
					CartEntity cartEntity=cartEntitylist.get(0);
					cartEntity.getFoodlist().remove(foodEntitylist.get(0));
					cartEntity=cartRepository.save(cartEntity);
					return UserCartUtils.convertCartEntityToCartJson(cartEntity);
				}
	
			}

		}
		else
			return null;
		return null;
	
	}






		
}
