package com.project.json;

public class UserJson {
	
	private long userId;

	private String password;

	private String usertype;

	private int loginstatus;

	private String sessionId;
	
	private UserProfileJson userprofile;
	
	public UserJson() {
		
	}
	
	public UserJson(String password, String usertype, int loginstatus, String sessionId, UserProfileJson userprofile) {
		super();
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
		this.sessionId = sessionId;
		this.userprofile = userprofile;
	}

	public UserJson(String password, String usertype, int loginstatus, UserProfileJson userprofile) {
		super();
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
		this.userprofile = userprofile;
	}

	public UserJson(long userId, String password, String usertype, int loginstatus, String sessionId) {
		super();
		this.userId = userId;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
		this.sessionId = sessionId;
	}

	public UserJson(String password, String usertype, int loginstatus) {
		super();
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
	}

	public UserJson(String password, String usertype, int loginstatus, String sessionId) {
		super();
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
		this.sessionId = sessionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public UserProfileJson getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfileJson userprofile) {
		this.userprofile = userprofile;
	}

	@Override
	public String toString() {
		return "UserJson [userId=" + userId + ", password=" + password + ", usertype=" + usertype + ", loginstatus="
				+ loginstatus + ", sessionId=" + sessionId + ", userprofile=" + userprofile + "]";
	}

	
	
	

}
