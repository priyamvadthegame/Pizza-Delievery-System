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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.Food;
import com.project.services.FoodService;

@Configurable
@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins="*")
public class FoodController {
	
	@Autowired
	private FoodService regService;
	
	@GetMapping("/food")
	public List<Food> getAllFood(){
		return regService.getAllFood();
	}
	
	@PostMapping(value="/food", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Food registerUser(@RequestBody Food food,@RequestHeader(name="auth-token")String id) {
		return regService.save(food, id);
	}

	@PutMapping(value="/food/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Food updateFood(@RequestBody Food food, @PathVariable(value="id") String id) {
		return regService.update(food, id);
	}
	
	@DeleteMapping(value="/food/{id}")
	public boolean deleteFood(@PathVariable(value="id") String id,@RequestHeader(name="auth-token")String sessionId) {
		return regService.delete(Long.valueOf(id),sessionId);
	}
	
	@GetMapping(value="/food/sort/price", produces=MediaType.APPLICATION_JSON_VALUE)
	public List <Food> sortFoodByPrice(){
		return regService.sortFoodByPrice();
	}
	
	@GetMapping(value="/food/search/{searchtext}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Food> filterFoodBySearchText(@PathVariable(value="searchtext") String searchtext){
		return regService.filterFoodBySearchText(searchtext);
	}
	
	@GetMapping(value="/food/type/{type}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Food> filterFoodByType(@PathVariable(value="type") String type){
		return regService.filterFoodByType(type);
	}

}
