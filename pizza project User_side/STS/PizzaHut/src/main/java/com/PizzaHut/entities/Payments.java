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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payments")
public class Payments {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int payId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userId")
	private Users users ;
	private double totalAmount;
	private String payStatus;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date payTimeStamp;
	private String mode;
	
	public Payments() {

	}

	public Payments(int payId, Users users, double totalAmount, String payStatus, Date payTimeStamp, String mode) {
		super();
		this.payId = payId;
		this.users = users;
		this.totalAmount = totalAmount;
		this.payStatus = payStatus;
		this.payTimeStamp = payTimeStamp;
		this.mode = mode;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public Date getPayTimeStamp() {
		return payTimeStamp;
	}

	public void setPayTimeStamp(Date payTimeStamp) {
		this.payTimeStamp = payTimeStamp;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return String.format("Payments [payId=%s, users=%s, totalAmount=%s, payStatus=%s, payTimeStamp=%s, mode=%s]",
				payId, users, totalAmount, payStatus, payTimeStamp, mode);
	}
	

}
