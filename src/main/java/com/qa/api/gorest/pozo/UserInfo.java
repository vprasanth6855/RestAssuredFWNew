package com.qa.api.gorest.pozo;

public class UserInfo {

	private String name;
	private String email;
	private String gender;
	private String status;
	private String dob;
	private Links links;
	
	public UserInfo(String name, String email, String gender, String status, String dob, Links links) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.dob = dob;
		this.links = links;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public Links getLink() {
		return links;
	}

	public void setLink(Links links) {
		this.links = links;
	}
	
	
	
	
	
}
