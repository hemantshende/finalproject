package com.PizzaHut.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.ToppingDao;
import com.PizzaHut.dao.toppingImageDao;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.dto.ToppingImageDto;
import com.PizzaHut.entities.ToppingImages;
import com.PizzaHut.entities.Toppings;

@Service
@Transactional
public class toppingImgService {

	@Autowired
	private toppingImageDao topImgDao;
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private ToppingDao toppingDao;
	
	public Map<String, Object> addToppingImage(int toppingId,ToppingImageDto dto){
		Toppings verifyItem = toppingDao.getById(toppingId);
		System.out.println(verifyItem);
		if (verifyItem != null) {
			ToppingImages add = convertor.toToppingImageEntity(dto, toppingId);
			System.out.println(add.getToppings());
			System.out.println("in service after");
			topImgDao.save(add);
			System.out.println("Added");
			return Collections.singletonMap("insertedId", add.getToppings());
		}else {
			return null;
		}
	}
	

	public ToppingImages findByImageId(int toppingImgId)
	{
		ToppingImages result=topImgDao.findByToppingImgId(toppingImgId);
		System.out.println(result);
		return result;
	}
	
	public List<ToppingImages> showAll()
	{
		return topImgDao.findAll();
	}
	
}
