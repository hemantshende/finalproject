package com.PizzaHut.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dto.ItemImgFormDto;
import com.PizzaHut.entities.ItemImage;
import com.PizzaHut.services.ItemImageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/itemImage")
public class ItemImageController {
	@Autowired
	private ItemImageService itemImgService;

	// add image of a item
	@PostMapping("/add/{itemid}")
	public ResponseEntity<?> addItemImage(@PathVariable("itemid") int itemid, ItemImgFormDto itemImg) {
		try {
			Map<String, Object> result = itemImgService.addItemImg(itemid, itemImg);
			if(!result.isEmpty()) {
				return Response.success(result);
			}else {
				return Response.error("No Item Found");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

	// get image by itemId
	@GetMapping(value = "/item/{itemId}", produces = "image/png")
	public @ResponseBody byte[] downloadItemImg(@PathVariable("itemId") int itemId) {
		try {
			ItemImage attachment = itemImgService.findItemById(itemId);
			if (attachment != null)
				return attachment.getData();
			return null;
		} catch (Exception e) {
			return null;
		}
	}

//	// Show all images
//	@GetMapping(value = "/allImages", produces = "image/png")
//	public ResponseEntity<?> imgList() {
//		List<byte[]> itemImgList = itemImgService.getAllImage();
//		System.out.println("in controller" + itemImgList);
//		if (itemImgList.isEmpty())
//			return null;
//		System.out.println("This is the line ===========>>");
//		return Response.success(itemImgList.listIterator());
//	}
}
