package com.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "")
public class CartEntity {
	

	@GeneratedValue
	@Id
	@Column(name = "")
	private long cartId;
	
	@Column(name = "")
	private int quantity;

	@Column(name = "")
	private String type;
	
	@Column(name="")
	private int price;
	
	@Column(name = "")
	private int foodId;
	
	@Column(name = "")
	@ManyToOne
	private UserEntity user;
	
	@Column(name="")
	private LocalDate date;

	public CartEntity() {
		super();
		
	}

	public CartEntity(int quantity, String type, int price, int foodId, LocalDate date) {
		super();
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		this.foodId = foodId;
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
		CartEntity other = (CartEntity) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartEntity [cartId=" + cartId + ", quantity=" + quantity + ", type=" + type + ", price=" + price
				+ ", foodId=" + foodId + ", user=" + user + ", date=" + date + "]";
	} 
	
	
	

}
