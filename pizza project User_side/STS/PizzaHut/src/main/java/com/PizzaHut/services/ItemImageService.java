package com.PizzaHut.services;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.ItemDao;
import com.PizzaHut.dao.ItemImageDao;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.dto.ItemImgFormDto;
import com.PizzaHut.entities.Item;
import com.PizzaHut.entities.ItemImage;

@Service
@Transactional
public class ItemImageService {
	@Autowired
	private ItemImageDao itemImgDao;
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private ItemDao itemDao;

	// add item
	public Map<String, Object> addItemImg(int itemId, ItemImgFormDto addItemImg) {
		Item verifyItem = itemDao.getById(itemId);
		System.out.println(verifyItem);
		if (verifyItem != null) {
			ItemImage add = convertor.toItemEntity(addItemImg, itemId);
			System.out.println("in service after");
			itemImgDao.save(add);
			return Collections.singletonMap("insertedId", add.getItem());
		}else {
			return null;
		}
	}

	// get image of item
	public ItemImage findItemById(int itemId) {
		Item forImage = new Item();
		forImage.setItemid(itemId);
		ItemImage getItem = itemImgDao.findByItem(forImage);
		if (getItem != null) {
			System.out.println("====>>" + getItem.getData());
			return getItem;
		}
		return null;
	}

	// get all image
//	public List<byte[]> getAllImage() {
//		List<ItemImage> itemImgList = itemImgDao.findAll();
////		List<Blob> blobImg = convertor.toblob(itemImgList);
//		return null;
//	}
}

//List<byte[]> imgList = new LinkedList<byte[]>();
//for(int i = 0; i<itemImgList.size(); i++) {
//	ItemImage transfer = itemImgList.get(i);
//	byte[] img = transfer.getData();
//	imgList.add(img);
//}
