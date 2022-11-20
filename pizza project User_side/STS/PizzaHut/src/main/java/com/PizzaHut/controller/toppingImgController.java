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

import com.PizzaHut.dto.ToppingImageDto;
import com.PizzaHut.entities.ToppingImages;
import com.PizzaHut.services.toppingImgService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/toppingImages")
public class toppingImgController {
	@Autowired
	private toppingImgService imgService;
	
	//add topping image
	@PostMapping("/add/{toppingId}")
	public ResponseEntity<?> addToppingImage(@PathVariable("toppingId") int toppingId,ToppingImageDto toppingImageDto){
		try {
			Map<String, Object> result = imgService.addToppingImage(toppingId, toppingImageDto);
			if(!result.isEmpty()) {
				return Response.success(result);
			}else {
				return Response.error("No Item Found");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	@GetMapping(value="/attachment/{toppingImgId}",produces = "image/png")
	public @ResponseBody byte[] showAttachment(@PathVariable("toppingImgId")int toppingImgId){
		try {
			ToppingImages attachment=imgService.findByImageId(toppingImgId);
			if(attachment==null)
				return null;
			return attachment.getData();
		} catch (Exception e) {
			return null;
		}
	}
	
//	@GetMapping(value="/attachment",produces="image/png")
//	public @ResponseBody ResponseEntity<?> showAll()
//	{
//		List<ToppingImages> list=imgService.showAll();
//		System.out.println();
//		Stream<ToppingImageDto> result=list.stream().map(ar->
//		convertor.toToppingImg(ar));
//		return Response.success(result);
//	}
}
