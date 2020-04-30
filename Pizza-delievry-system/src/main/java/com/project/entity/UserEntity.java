package com.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "USER_CREDENTIALS")
public class UserEntity {
	
	@GeneratedValue
	@Id
	@Column(name = "USERID")
	private long userId;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "USERTYPE")
	private String usertype;
	
	@Column(name = "LOGIN_STATUS")
	private int loginstatus;
	
	@Column(name = "SESSION_ID")
	private String sessionId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
    private List<OrderEntity> orders = new ArrayList<OrderEntity>();
	
	@OneToMany(mappedBy = "user")
    private List<CartEntity> carts = new ArrayList<CartEntity>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "creditCardNumber")
    private List<CreditCardEntity> cards = new ArrayList<CreditCardEntity>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID")
    private UserProfileEntity userprofile;
	
	public UserEntity() {
		
	}

	public UserEntity(String password, String usertype, int loginstatus, String sessionId) {
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

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public List<CartEntity> getCarts() {
		return carts;
	}

	public void setCarts(List<CartEntity> carts) {
		this.carts = carts;
	}

	public List<CreditCardEntity> getCards() {
		return cards;
	}

	public void setCards(List<CreditCardEntity> cards) {
		this.cards = cards;
	}

	public UserProfileEntity getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfileEntity userprofile) {
		this.userprofile = userprofile;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", password=" + password + ", usertype=" + usertype + ", loginstatus="
				+ loginstatus + ", sessionId=" + sessionId + ", orders=" + orders + ", carts=" + carts + ", cards="
				+ cards + ", userprofile=" + userprofile + "]";
	}

	

	
	
	
	

}
