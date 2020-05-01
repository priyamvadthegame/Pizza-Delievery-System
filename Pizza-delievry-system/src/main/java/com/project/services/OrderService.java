package com.project.services;

import java.util.List;

import com.project.json.OrderJson;

public interface OrderService {

	 public OrderJson save(OrderJson order, String authToken, long cartId);

	public List<OrderJson> getOrderBySessionId(String authToken);
    
	public List<OrderJson> getOrderByStatus(String authToken,String status);
}
