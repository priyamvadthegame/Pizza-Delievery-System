package com.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.Food;
import com.project.services.FoodService;

@RestController
@RequestMapping("/myapp")
public class FoodController {
	
	@Autowired
	private FoodService regService;
	
	@GetMapping("/food")
	public List<Food> getAllFood(){
		return regService.getAllFood();
	}
	
	@PostMapping(value="/food", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Food registerUser(@RequestBody Food food) {
		return regService.save(food);
	}

	@PutMapping(value="/food/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Food updateFood(@RequestBody Food food, @PathVariable(value="id") String id) {
		return regService.update(food, id);
	}
	
	@DeleteMapping(value="/food/{id}")
	public boolean deleteFood(@PathVariable(value="id") String id) {
		return regService.delete(id);
	}

}
