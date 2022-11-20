package com.PizzaHut.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	@Column(name="FirstName")
	private String firstName;	
	@Column(name="LastName")
	private String lastName;
	private String email;
	private String phoneNo;
	private String feedback;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date feedBackTime;
	
	public Feedback() {
		super();
	}

	public Feedback(int feedbackId, String firstName, String lastName, String email, String phoneNo, String feedback,
			Date feedBackTime) {
		super();
		this.feedbackId = feedbackId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.feedback = feedback;
		this.feedBackTime = feedBackTime;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getFeedBackTime() {
		return feedBackTime;
	}

	public void setFeedBackTime(Date feedBackTime) {
		this.feedBackTime = feedBackTime;
	}

	@Override
	public String toString() {
		return String.format(
				"Feedback [feedbackId=%s, firstName=%s, lastName=%s, email=%s, phoneNo=%s, feedback=%s, feedBackTime=%s]",
				feedbackId, firstName, lastName, email, phoneNo, feedback, feedBackTime);
	}

	
}
