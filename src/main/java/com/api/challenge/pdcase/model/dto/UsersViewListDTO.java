package com.api.challenge.pdcase.model.dto;

import java.util.Date;

public class UsersViewListDTO {

	private Integer id;
	
	private String username;
	
	private boolean enabled;
	
	private Date registerDate;
	
	private String name;
	
	private String surName;
	
	private String email;
	
	private String phone;

	public UsersViewListDTO() {
	}

	public UsersViewListDTO(Integer id, String username, boolean enabled, Date registerDate, String name, String surName,
			String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.enabled = enabled;
		this.registerDate = registerDate;
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
