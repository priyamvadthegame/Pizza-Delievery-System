package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.Food;
import com.project.json.StoreJson;
import com.project.services.StoreService;

@Configurable
@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins="*")
public class StoreController {

	
	@Autowired
	private StoreService storeService;
	
	@GetMapping(value="/store")
	public List<StoreJson> getAllFood(){
		return storeService.getStoreList();
	}
	
	@PostMapping(value="/store1", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)

	public  StoreJson registerStore(@RequestBody StoreJson store) {
		return storeService.registerStore(store);
	}
		
	@DeleteMapping(value="/store/{id}")
	public boolean deleteStore(@PathVariable(value="id") Long id) {
			return storeService.deleteStore(id);
		}
	
	@GetMapping(value="/store/food/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StoreJson> filterStoreByFood(@PathVariable(value="id") Long id){
		return storeService.filterStoreByFood(id);
	}
	
	@PostMapping(value="/store1/food", produces=MediaType.APPLICATION_JSON_VALUE)
	public Food addFoodToStore(@RequestParam(name = "foodId")long foodId,@RequestParam(name = "storeId")long storeId,@RequestHeader(name = "authToken")String authToken){
		return storeService.addFoodtoStore(foodId, storeId, authToken);
	}
	
	@DeleteMapping(value="/store/food", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Food> deleteFoodFromStore(@RequestParam(name = "foodId")String foodId,@RequestParam(name = "storeId")String storeId,@RequestHeader(name = "authToken")String authToken){
		return storeService.deleteFoodFromStore(Long.valueOf(foodId), Long.valueOf(storeId), authToken);
	}
	
	
}

