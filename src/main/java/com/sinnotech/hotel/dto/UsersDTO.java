package com.sinnotech.hotel.dto;

import java.util.Date;

public class UsersDTO {
	private int id;
	private String name;
	private String phone;
	private String phoneForView;
	private String email;
	private String password;
	private String confirmPassword;
	private boolean temporary;
	private char role;
	private Date createdAt;
	private Date updatedAt;
	private boolean deleteFlag;
	private String emailForView;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone.length() > 4) {
			StringBuilder phoneMasking = new StringBuilder();
			phoneMasking.append(phone);
			phoneMasking.replace(phoneMasking.length()-4, phoneMasking.length(), "****");
			phoneForView = phoneMasking.toString();
		}else {
			phoneForView = phone;
		}
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.contains("@")) {
			String masking = "";
			for (int i = 0; i < email.split("@")[0].length(); i++) {
				masking += "*";
			}
			emailForView = email.replaceFirst(email.split("@")[0], masking);
		}else {
			emailForView = email;
		}
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isTemporary() {
		return temporary;
	}

	public void setTemporary(boolean temporary) {
		this.temporary = temporary;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getEmailForView() {
		return emailForView;
	}

	public void setEmailForView(String emailForView) {
		this.emailForView = emailForView;
	}

	public String getPhoneForView() {
		return phoneForView;
	}

	public void setPhoneForView(String phoneForView) {
		this.phoneForView = phoneForView;
	}

}
