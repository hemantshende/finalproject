package com.PizzaHut.entities;

import java.util.Date;
import java.util.Arrays;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "itemImage")
public class ItemImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemImgId;
	@OneToOne
	@JoinColumn(name = "itemId")//FK for itemimage
	private Item item;
	@Lob
	private byte [] data;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date itemImgTime;
	
	public ItemImage() {
		// TODO Auto-generated constructor stub
	}

	public ItemImage(int itemImgId, Item item, byte[] data, Date itemImgTime) {
		super();
		this.itemImgId = itemImgId;
		this.item = item;
		this.data = data;
		this.itemImgTime = itemImgTime;
	}

	public int getItemImgId() {
		return itemImgId;
	}

	public void setItemImgId(int itemImgId) {
		this.itemImgId = itemImgId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Date getTime() {
		return itemImgTime;
	}

	public void setTime(Date itemImgTime) {
		this.itemImgTime = itemImgTime;
	}

	@Override
	public String toString() {
		return "ItemImage [itemImgId=" + itemImgId + ", item=" + item + ", data=" + Arrays.toString(data) + ", time="
				+ itemImgTime + "]";
	}
}
