package com.PizzaHut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dto.DeliveryDto;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.services.DeliveryStatusService;

@CrossOrigin(origins = "*")
@Controller
@RestController
@RequestMapping("/DeliveryStatus")
public class DeliveryStatusController {

	@Autowired
	private DeliveryStatusService statusService;

	// get delivery
	@GetMapping("/{userId}")
	public ResponseEntity<?> viewDeliveryStatus(@PathVariable("userId") int userId) {
		try {
			System.out.println("In delivery controller");
			List<DeliveryStatus> result = statusService.findByUserId(userId);
			System.out.println(result);
			if (result.isEmpty())
				return Response.error("No result found");
			return Response.success(result);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> adddelivery(@RequestBody DeliveryDto deliveryDto) {
		try {
			@SuppressWarnings("unused")
			DeliveryStatus newDelivery = statusService.addForDelivery(deliveryDto);
			return Response.success("Delivery added");
		} catch (Exception e) {

			return Response.error(e.getMessage());
		}
	}

	// get all delivery
	@GetMapping("/alldelivery")
	public ResponseEntity<?> getAllDelivery() {
		try {
			List<DeliveryStatus> allDelList = statusService.fetchAllDelivery();
			if (!allDelList.isEmpty()) {
				return Response.success(allDelList);
			} else {
				return Response.error("No deliveries");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
}
