package com.project.json;

import java.time.LocalDate;


import com.project.entity.UserEntity;

public class CartJson {
	
	private long cartId;
	
	
	private int quantity;

	
	private String type;
	
	
	private int price;
	
	
	private int foodId;
	
	
	private UserEntity user;
	
	
	private LocalDate date;


	public CartJson() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartJson(long cartId, int quantity, String type, int price, int foodId, UserEntity user, LocalDate date) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		this.foodId = foodId;
		this.user = user;
		this.date = date;
	}


	public CartJson(int quantity, String type, int price, int foodId, UserEntity user, LocalDate date) {
		super();
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		this.foodId = foodId;
		this.user = user;
		this.date = date;
	}


	public long getCartId() {
		return cartId;
	}


	public void setCartId(long cartId) {
		this.cartId = cartId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartJson other = (CartJson) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CartJson [cartId=" + cartId + ", quantity=" + quantity + ", type=" + type + ", price=" + price
				+ ", foodId=" + foodId + ", user=" + user + ", date=" + date + "]";
	}
	
	

}
