package com.PizzaHut.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Toppings;


public interface ToppingDao extends JpaRepository<Toppings, Integer>{

}
