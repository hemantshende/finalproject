package com.PizzaHut.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "toppingImage")
public class ToppingImages {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int toppingImgId;
	@OneToOne
	@JoinColumn(name = "toppingId")
	private Toppings toppings;
	@Lob
	private byte[] Data;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date toppingImgTime;

	public ToppingImages() {
		// TODO Auto-generated constructor stub
	}

	public ToppingImages(int toppingImgId, Toppings toppings, byte[] data, Date toppingImgTime) {
		super();
		this.toppingImgId = toppingImgId;
		this.toppings = toppings;
		Data = data;
		this.toppingImgTime = toppingImgTime;
	}

	public int getToppingImgId() {
		return toppingImgId;
	}

	public void setToppingImgId(int toppingImgId) {
		this.toppingImgId = toppingImgId;
	}

	public Toppings getToppings() {
		return toppings;
	}

	public void setToppings(Toppings toppings) {
		this.toppings = toppings;
	}

	public byte[] getData() {
		return Data;
	}

	public void setData(byte[] data) {
		Data = data;
	}

	public Date getToppingImgTime() {
		return toppingImgTime;
	}

	public void setToppingImgTime(Date toppingImgTime) {
		this.toppingImgTime = toppingImgTime;
	}

	@Override
	public String toString() {
		return "ToppingImages [toppingImgId=" + toppingImgId + ", toppings=" + toppings + ", Data="
				+ Arrays.toString(Data) + ", toppingImgTime=" + toppingImgTime + "]";
	}
	
	

}
