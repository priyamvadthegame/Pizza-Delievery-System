package com.project.utils;

import java.util.ArrayList;
import java.util.List;
import com.project.entity.OrderEntity;
import com.project.json.OrderJson;

public class OrderUtils {
	public static OrderEntity convertOrderJsontoEntity(OrderJson order)
	{
		return new OrderEntity(order.getOrderStatus(),order.getStreet(),order.getCity(),order.getState(),order.getPincode(), order.getMobileNo());
	}
	
	public static OrderJson convertOrderEntitytoJson(OrderEntity order)
	{
		return new OrderJson(order.getOrderStatus(),order.getStreet(),order.getCity(),order.getState(),order.getPincode(), order.getMobileNo());
	}
	
	public static List<OrderJson> convertOrderEntityListtoJsonList(List<OrderEntity> orderList)
	{	List<OrderJson> orderJsonList=new ArrayList<>();
		 orderList.stream().forEach((order)->orderJsonList.add(convertOrderEntitytoJson(order)));
		 
		 return orderJsonList;
	}
}
