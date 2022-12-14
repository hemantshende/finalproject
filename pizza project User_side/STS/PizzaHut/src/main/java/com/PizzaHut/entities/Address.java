package com.PizzaHut.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int AddressId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users user;
	private String plotNo;
	private String streetName;
	private String city;
	private String district;
	private String soverignState;
	private String pincode;
	
	public Address() {
		super();
	}

	public Address(int addressId, Users user, String plotNo, String streetName, String city, String district,
			String soverignState, String pincode) {
		super();
		AddressId = addressId;
		this.user = user;
		this.plotNo = plotNo;
		this.streetName = streetName;
		this.city = city;
		this.district = district;
		this.soverignState = soverignState;
		this.pincode = pincode;
	}
	
	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSoverignState() {
		return soverignState;
	}

	public void setSoverignState(String soverignState) {
		this.soverignState = soverignState;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", user=" + user + ", plotNo=" + plotNo + ", streetName="
				+ streetName + ", city=" + city + ", district=" + district + ", soverignState=" + soverignState
				+ ", pincode=" + pincode + "]";
	}

	
}