package com.PizzaHut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dto.DeliveryDto;
import com.PizzaHut.dto.PaymentDto;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Payments;
import com.PizzaHut.services.DeliveryStatusService;
import com.PizzaHut.services.PaymentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService payService;
	@Autowired
	private DeliveryStatusService deliveryService;

	
	//add Payment
	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayments(@RequestBody PaymentDto paymentDto)
	{
		try {
			Payments newPayment=payService.addPayments(paymentDto);
			System.out.println("Inserted in payments table");
			DeliveryDto addDelivery = new DeliveryDto();
			addDelivery.setPayId(newPayment.getPayId());
			addDelivery.setDeliveryStatus("Order Received");
			addDelivery.setAddressid(paymentDto.getAddresspayId());
			addDelivery.setUserId(paymentDto.getUserId());
			addDelivery.setDeliveryTime(newPayment.getPayTimeStamp());
			DeliveryStatus added = deliveryService.addForDelivery(addDelivery);
			return Response.success(added);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	@GetMapping("/showCurrent/{payId}")
	public ResponseEntity<?> showCurrentPayment(@PathVariable("payId")int payId)
	{
		try {
			Payments curPayment=payService.findPayments(payId);
			System.out.println(curPayment);
			if(curPayment==null)
				return Response.error("No result found");
			return Response.success(curPayment);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
}
