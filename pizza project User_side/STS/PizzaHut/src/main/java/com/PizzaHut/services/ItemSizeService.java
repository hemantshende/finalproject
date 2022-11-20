package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.ItemSizeDao;
import com.PizzaHut.entities.ItemSize;

@Service
@Transactional
public class ItemSizeService {
	@Autowired
	private ItemSizeDao itemSizeDao;
	
	//show by sizeId
	public List<ItemSize> SizeOfPizza(String size, int itemId){
		List<ItemSize> thisSize = itemSizeDao.getSizeOfPizza(size, itemId);
		return thisSize;
	}
}