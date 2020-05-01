package com.project.json;

public class UserJson {
	
	private long userId;
	
	private String username;

	private String password;

	private String usertype;

	private String loginstatus;
	
	private UserProfileJson userprofile;
	
	public UserJson() {
		
	}

	public UserJson(long userId, String username, String password, String usertype, String loginstatus,
			UserProfileJson userprofile) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
		this.userprofile = userprofile;
	}

	public UserJson(String username, String password, String usertype, String loginstatus,
			UserProfileJson userprofile) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
		this.userprofile = userprofile;
	}

	public UserJson(String username, String password, String usertype, String loginstatus) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
	}

	public UserJson(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public UserJson(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}

	public UserProfileJson getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfileJson userprofile) {
		this.userprofile = userprofile;
	}

	@Override
	public String toString() {
		return "UserJson [userId=" + userId + ", username=" + username + ", password=" + password + ", usertype="
				+ usertype + ", loginstatus=" + loginstatus + ", userprofile=" + userprofile + "]";
	}
	
	
	

}
