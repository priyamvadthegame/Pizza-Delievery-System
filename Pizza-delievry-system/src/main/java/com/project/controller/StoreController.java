package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.json.StoreJson;
import com.project.services.StoreService;

@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins="*")
public class StoreController {

	
	@Autowired
	private StoreService storeService;
	
	@PostMapping(value="/store", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public  StoreJson registerStore(@RequestBody StoreJson store) {
		return storeService.save(store);
	}
		
	@DeleteMapping(value="/store/{id}")
	public boolean deleteStore(@PathVariable(value="id") Long id) {
			return storeService.deleteStore(id);
		}
	
	@GetMapping(value="/store/food/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StoreJson> filterStoreByFood(@PathVariable(value="id") Long id){
		return storeService.filterStoreByFood(id);
	}
	
	@GetMapping(value="/store/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StoreJson> getFoodInStore(@PathVariable(value="id") Long id){
		return storeService.getFoodInStore(id);
	}
	
	
}

