package com.PizzaHut.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;

public class ItemImgFormDto {
	private MultipartFile data;
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	public ItemImgFormDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemImgFormDto(int itemid, MultipartFile image, Date time) {
		super();
		this.data = image;
		this.time = time;
	}

	public MultipartFile getData() {
		return data;
	}

	public void setData(MultipartFile data) {
		this.data = data;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ItemImgFormDto [data=" + data + ", time=" + time + "]";
	}

	
}
