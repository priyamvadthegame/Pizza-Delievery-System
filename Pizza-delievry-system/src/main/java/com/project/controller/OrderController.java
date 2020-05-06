package com.project.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ListWrapper;
import com.project.json.OrderJson;
import com.project.services.OrderService;

@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins="*")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping(value="/food/order", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public OrderJson  postOrder(@RequestBody OrderJson order,@RequestHeader(name="authToken") String authToken ,@RequestParam(name="foods")String[] foodList,@RequestParam(name = "totalprice") String TotalPrice,@RequestParam(name = "storeId") String storeId)
    {	//String foodId[]=new String [foodList.getFoodList().size()];
		//foodList.getFoodList().stream().forEach((foods)->{ int k=0;foodId[k++]=foods;});
		return orderService.save(order,authToken,foodList,Long.valueOf(TotalPrice),Long.valueOf(storeId));
	}
	
	@GetMapping(value="/order/user",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderJson> getOrderBySessionId(@RequestHeader(name="auth-token") String authToken ) {
		return orderService.getOrderBySessionId(authToken);
	}
	
	@GetMapping(value="/order/user/{status}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderJson> getOrderByStatus(@RequestHeader(name="auth-token") String authToken, @PathVariable(name = "status") String status) {
		return orderService.getOrderByStatus(authToken,status);
	}
}
