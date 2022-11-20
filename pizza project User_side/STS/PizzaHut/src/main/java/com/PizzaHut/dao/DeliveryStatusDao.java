package com.PizzaHut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Users;

public interface DeliveryStatusDao extends JpaRepository<DeliveryStatus	,Integer>{
	List<DeliveryStatus> findByUsers(Users user);
}
