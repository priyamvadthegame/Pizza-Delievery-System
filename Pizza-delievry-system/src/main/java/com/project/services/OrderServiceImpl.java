package com.project.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.CartEntity;
import com.project.entity.FoodEntity;
import com.project.entity.OrderEntity;
import com.project.entity.StoreEntity;
import com.project.entity.UserEntity;
import com.project.json.OrderJson;
import com.project.repositories.FoodRepository;
import com.project.repositories.OrderRepository;
import com.project.repositories.StoreRepository;
import com.project.repositories.UserCartRepository;
import com.project.repositories.UserRepository;
import com.project.utils.OrderUtils;
import com.project.utils.StoreUtils;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private  FoodRepository foodRepository;
	
	@Autowired
	private  UserCartRepository cartRepository;
	@Autowired
	private  StoreRepository storecartRepository;

	@Override
	public OrderJson save(OrderJson order, String authToken,String foodArray[],long price,long storeId) {
	
		
		UserEntity userEntity=getUserEntityBySessionId(authToken);
		if(userEntity!=null)
		{
				OrderEntity orderEntity=OrderUtils.convertOrderJsontoEntity(order);
				StoreEntity storeEntity=storecartRepository.findById(storeId).get();
				List<FoodEntity> foodlist=new ArrayList<>();
				CartEntity cartEntity =new CartEntity();
				for(String food : foodArray)
				{	System.out.println(food);
					FoodEntity foodEntity =foodRepository.findById(Long.valueOf(food)).get();
					foodEntity.getCartEntity().add(cartEntity);
					foodlist.add(foodEntity);
				
					
				}
				cartEntity.setFoodList(foodlist);
				cartEntity.setUser(userEntity);
				cartEntity.setPrice(Integer.valueOf(String.valueOf(price)));
				cartEntity.setDate(LocalDate.now());
				cartEntity=cartRepository.save(cartEntity);
				for(String food : foodArray)
				{	FoodEntity foodEntity =foodRepository.findById(Long.valueOf(food)).get();
					
					foodEntity.getCartEntity().add(cartEntity);
				}
				orderEntity.setCartId(cartEntity);
				orderEntity.setStoreId(storeEntity);
				orderEntity.setUserId(userEntity);
				orderEntity=orderRepository.save(orderEntity);
				
				return OrderUtils.convertOrderEntitytoJson(orderEntity);
			}
				
		
		else
		{
			return new OrderJson("Your session has expired. Please login to continue.","","","",0L,"");
		}
		
	}

	@Override
	public List<OrderJson> getOrderBySessionId(String authToken) {
		
		UserEntity userEntity=getUserEntityBySessionId(authToken);
		if(userEntity!=null)
		{
			return OrderUtils.convertOrderEntityListtoJsonList(userEntity.getOrders());	
		}
		else {
			List<OrderJson> errorList= new ArrayList<OrderJson> ();
					errorList.add( new OrderJson("Your session has expired. Please login to continue.","","","",0L,""));
			return errorList;
		}
		
	}
	@Override
	public List<OrderJson> getOrderByStatus(String authToken,String status){
		
		UserEntity userEntity=getUserEntityBySessionId(authToken);
		if(userEntity!=null)
		{
			List <OrderEntity> orderList =userEntity.getOrders();
			List <OrderEntity> filterList=orderList.stream().filter(obj->obj.getOrderStatus().toLowerCase().equals(status.toLowerCase())).collect(Collectors.toList());
			return OrderUtils.convertOrderEntityListtoJsonList(filterList);	
		}
		else {
			List<OrderJson> errorList= new ArrayList<OrderJson> ();
					errorList.add( new OrderJson("Your session has expired. Please login to continue.","","","",0L,""));
			return errorList;
		}
	}

	public  UserEntity getUserEntityBySessionId(String sessionId)
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
