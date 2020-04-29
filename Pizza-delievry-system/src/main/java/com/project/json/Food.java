package com.spring.json;

public class Food {

	private long id;
	private String userName;
	private String firstName;
	private String password;
	private String email;
	private String sessionId=null;
	
	public Food() {
		super();
	}

	public Food(long id,String userName, String firstName, String password, String email, String sessionId) {
		super();
		this.id=id;
		this.userName = userName;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
		this.sessionId = sessionId;
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



	public String getSessionId() {
		return sessionId;
	}



	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}



	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", password=" + password
				+ ", email=" + email + ", sessionId=" + sessionId + "]";
	}
}
