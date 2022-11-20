package com.PizzaHut.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="deliverystatus")
public class DeliveryStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryId;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="payId")
	private Payments payments;
	@ManyToOne
	@JoinColumn(name="userId")
	private Users users;
	@ManyToOne
	@JoinColumn(name="AddressId")
	private Address address;
	private String deliveryStatus;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date deliveryTime;
	
	public DeliveryStatus() {
		super();
	}

	public DeliveryStatus(int deliveryId, Payments payments, Users users, Address address, String deliveryStatus,
			Date deliveryTime) {
		super();
		this.deliveryId = deliveryId;
		this.payments = payments;
		this.users = users;
		this.address = address;
		this.deliveryStatus = deliveryStatus;
		this.deliveryTime = deliveryTime;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Override
	public String toString() {
		return "DeliveryStatus [deliveryId=" + deliveryId + ", payments=" + payments + ", users=" + users + ", address="
				+ address + ", deliveryStatus=" + deliveryStatus + ", deliveryTime=" + deliveryTime + "]";
	}

	
	
}
