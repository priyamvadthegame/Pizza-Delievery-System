package com.project.entity;



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
	@Column(name = "USER_UNIQUE_ID")
	private long userId;

	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "USERTYPE")
	private String usertype;
	
	@Column(name = "LOGIN_STATUS")
	private String loginStatus;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "userId")
    private List<OrderEntity> orders;
	
	@OneToMany(mappedBy = "user")
    private List<CartEntity> carts;
	

	@OneToMany( mappedBy = "userId")

    private List<CreditCardEntity> cards;
	
	@OneToOne( targetEntity = UserProfileEntity.class)
    private UserProfileEntity userprofile;
	
	public UserEntity() {
		
	}

	public UserEntity(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public UserEntity(String username, String password, String usertype, String loginStatus) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.loginStatus = loginStatus;
	}

	public UserEntity(String username, String password) {
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

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
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

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", username=" + username + ", password=" + password + ", usertype="
				+ usertype + ", loginStatus=" + loginStatus + ", orders=" + orders + ", carts=" + carts + ", cards="
				+ cards + ", userprofile=" + userprofile + "]";
	}
	
	

}
