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

import com.PizzaHut.entities.Toppings;
import com.PizzaHut.services.ToppingsService;

@CrossOrigin(origins = "*")
@Controller
@RestController
@RequestMapping("/toppings")
public class ToppingController {

	@Autowired
	private ToppingsService toppingsService;

	//get all toppings
	@GetMapping("/showAll")
	public ResponseEntity<?> findAllToppings() {
		try {
			List<Toppings> checkTopping = toppingsService.findAllToppings();
			if (checkTopping == null)
				return Response.error("Empty");
			return Response.success(checkTopping);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

	//get topping by topping ID
	@GetMapping("/{toppingId}")
	public ResponseEntity<?> findByToppingId(@PathVariable("toppingId") int toppingId) {
		try {
			System.out.println("In controller");
			List<Toppings> result = toppingsService.findByToppingId(toppingId);
			System.out.println(result);
			if (result == null)
				return Response.error("No result");
			return Response.success(result);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
}
