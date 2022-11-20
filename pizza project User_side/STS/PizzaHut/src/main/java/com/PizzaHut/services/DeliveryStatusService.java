package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.DeliveryStatusDao;
import com.PizzaHut.dto.DeliveryDto;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Users;

@Service
@Transactional
public class DeliveryStatusService {

	@Autowired
	private DeliveryStatusDao statusDao;
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private CartService cartService;

	//get list of delivery by userid
	public List<DeliveryStatus> findByUserId(int userId) {
		Users getDeliveries = new Users();
		getDeliveries.setUserId(userId);
		List<DeliveryStatus> deliveryList = statusDao.findByUsers(getDeliveries);
		return deliveryList;
	}

	// get all delivery
	public List<DeliveryStatus> fetchAllDelivery() {
		List<DeliveryStatus> deliveryList = statusDao.findAll();
		return deliveryList;
	}

	public DeliveryStatus addForDelivery(DeliveryDto deliveryDto) {
		DeliveryStatus add = convertor.toDelivery(deliveryDto);
		statusDao.save(add);
		cartService.addForeignKey(add.getDeliveryId(), deliveryDto.getUserId());
		return add;
	}
}
