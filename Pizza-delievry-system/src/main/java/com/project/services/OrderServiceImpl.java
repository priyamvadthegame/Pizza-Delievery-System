package com.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.CartEntity;
import com.project.entity.OrderEntity;
import com.project.entity.UserEntity;
import com.project.json.OrderJson;
import com.project.repositories.OrderRepository;
import com.project.repositories.UserRepository;
import com.project.utils.OrderUtils;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private static UserRepository userRepository;

	@Override
	public OrderJson save(OrderJson order, String authToken,long cartId) {
	
		
		UserEntity userEntity=getUserEntityBySessionId(authToken);
		if(userEntity!=null)
		{
			List<CartEntity> cartEntity =userEntity.getCarts(); 
			
			if(cartEntity.stream().filter(cart -> cart.getCartId()==cartId ).findAny().isPresent()) 
			{
				CartEntity cart=cartEntity.stream().filter(cart1 -> cart1.getCartId()==cartId ).collect(Collectors.toList()).get(0);
				OrderEntity orderEntity=OrderUtils.convertOrderJsontoEntity(order);
				orderEntity.setCartId(cart);
				orderEntity.setUserId(userEntity);
				orderRepository.save(orderEntity);
				
				return OrderUtils.convertOrderEntitytoJson(orderEntity);
			}
			else {
				
				return new OrderJson("This Cart not available with the given id","","","",0L,0);
			}
				
		}
		else
		{
			return new OrderJson("Your session has expired. Please login to continue.","","","",0L,0);
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
					errorList.add( new OrderJson("Your session has expired. Please login to continue.","","","",0L,0));
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
					errorList.add( new OrderJson("Your session has expired. Please login to continue.","","","",0L,0));
			return errorList;
		}
	}

	public static  UserEntity getUserEntityBySessionId(String sessionId)
	{
		List<UserEntity> userEntity=userRepository.findByLoginstatus(sessionId);
		
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
