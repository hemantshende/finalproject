package com.PizzaHut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.Item;
import com.PizzaHut.services.ItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
//	@Autowired
//	private ItemImageController itemImgController;

	// to get all items
	@GetMapping("/showAll")
	public ResponseEntity<?> findAllItems() {
		try {
			List<Item> checkItem = itemService.findAllItem();
			if (checkItem != null)
				return Response.success(checkItem);
			return Response.error("Empty");
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

	// get item by itemId
	@GetMapping("/byid/{itemId}")
	public ResponseEntity<?> findByItemId(@PathVariable("itemId") int itemId) {
		try {
			System.out.println("In controller");
			Item result = itemService.findByItemId(itemId);
			if (result == null)
				return Response.error("No result found");
			return Response.success(result);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	//get all by type
	@GetMapping("/bytype/{type}")
	public ResponseEntity<?> getByType(@PathVariable("type") String type){
		try {
//			System.out.println("In controller");
			List<Item> listByItem = itemService.findByType(type);
//			System.out.println(result);
			if (listByItem == null)
				return Response.error("No result found");
			return Response.success(listByItem);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
}
