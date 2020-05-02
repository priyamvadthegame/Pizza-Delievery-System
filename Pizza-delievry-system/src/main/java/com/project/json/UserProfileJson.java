package com.project.json;

import java.time.LocalDate;

public class UserProfileJson {

private long userId;
	
	private String firstname;

	private String lastname;

	LocalDate dob;

	private String gender;

	private String street;

	private String location;

	private String city;

	private String state;

	private String pincode;
	
	private String mobileno;
	
	private String emailId;
	

	private UserJson user;
	
	public UserProfileJson() {
		
	}

	public UserProfileJson(String firstname, String lastname, LocalDate dob, String gender, String street,
			String location, String city, String state, String pincode, String mobileno, String emailId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileno = mobileno;
		this.emailId = emailId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserJson getUser() {
		return user;
	}

	public void setUser(UserJson user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProfileJson [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", dob="
				+ dob + ", gender=" + gender + ", street=" + street + ", location=" + location + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", mobileno=" + mobileno + ", emailId=" + emailId
				+ ", user=" + user + "]";
	}

	
	
	
}
