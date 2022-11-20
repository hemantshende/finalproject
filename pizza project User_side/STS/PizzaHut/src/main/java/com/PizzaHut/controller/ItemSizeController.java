package com.PizzaHut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.ItemSize;
import com.PizzaHut.services.ItemSizeService;

@CrossOrigin(origins = "*")
@Controller
@RestController
@RequestMapping("/itemSize")
public class ItemSizeController {
	@Autowired
	private ItemSizeService itemSizeService;
	
	// show itemSize by itemId
	@GetMapping("/{itemid}/{size}")
	public ResponseEntity<?> fetchByItemSizeId(@PathVariable("itemid") int itemId, @PathVariable("size") String size) {
		try {
			List<ItemSize> sizeOfPizza = itemSizeService.SizeOfPizza(size, itemId);
			if(!sizeOfPizza.isEmpty()) {
				return Response.success(sizeOfPizza);
			}else {
				return Response.error("This pizaa is not available in this Size");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
}
