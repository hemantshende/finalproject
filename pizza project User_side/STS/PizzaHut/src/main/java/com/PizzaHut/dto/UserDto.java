package com.PizzaHut.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {
	
	private int userId;
	private String firstName;
	
	private String lastName;
	@Email
	@NotBlank
	private String email;
	@Email
	@NotBlank
	private String password;
	
	private String role;
	
	private String phoneNo;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(int userId, String firstName, String lastName, @Email @NotBlank String email,
			@Email @NotBlank String password, String role, String phoneNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phoneNo = phoneNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return String.format(
				"UserDto [userId=%s, firstName=%s, lastName=%s, email=%s, password=%s, role=%s, phoneNo=%s]", userId,
				firstName, lastName, email, password, role, phoneNo);
	}

	
}
