package com.PizzaHut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.ItemSize;

public interface ItemSizeDao extends JpaRepository<ItemSize, Integer>{
	@Query(value="SELECT * from itemsize WHERE size=?1 and itemId=?2",nativeQuery = true)
	List<ItemSize> getSizeOfPizza(String size,Integer itemId);
}
