package com.project.json;

public class Food {

	private long id;
	private String userName;
	private String firstName;
	private String password;
	private String email;
	
	public Food() {
		super();
	}

	public Food(long id,String userName, String firstName, String password, String email) {
		super();
		this.id=id;
		this.userName = userName;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
	}



	public Food(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", password=" + password
				+ ", email=" + email + "]";
	}
}

