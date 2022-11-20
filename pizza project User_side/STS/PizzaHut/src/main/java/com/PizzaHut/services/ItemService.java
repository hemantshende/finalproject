package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.ItemDao;
import com.PizzaHut.entities.Item;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	// show all items in the list
		public List<Item> findAllItem() {
			return itemDao.findAllPizza();
		}

	// show selected item by it's Id
	public Item findByItemId(int itemId) {
		Item item = itemDao.getById(itemId);
		return item;
	}
	
	public List<Item> findByType(String type){
		List<Item> listBytype = itemDao.findByType(type);
		if(listBytype != null) {
			return listBytype;
		}
		return null;
	}
}
