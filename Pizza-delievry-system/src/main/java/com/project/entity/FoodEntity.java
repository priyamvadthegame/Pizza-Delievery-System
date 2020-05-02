package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOOD_MASTER")
public class FoodEntity {

	@GeneratedValue
	@Id
	@Column(name = "FOOD_ID")
	private long id;
	
	@Column(name = "FOOD_NAME")
	private String foodName;

	@Column(name = "FOOD_TYPE")
	private String foodType;
	
	@Column(name = "FOOD_SIZE")
	private String foodSize;
	
	@Column(name = "FOOD_QUANTITY")
	private int quantity;
	
	@Column(name = "FOOD_PRICE")
	private double price;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cart_id")
	private List<CartEntity> cartList;

	

	public FoodEntity() {
		super();
	}




	public FoodEntity(long id, String foodtName, String foodType, String foodSize, int quantity, double price,
			List<CartEntity> cartList) {
		super();
		this.id = id;
		this.foodName = foodtName;
		this.foodType = foodType;
		this.foodSize = foodSize;
		this.quantity = quantity;
		this.price = price;
		this.cartList = cartList;
	}



	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getFoodName() {
		return foodName;
	}




	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}




	public String getFoodType() {
		return foodType;
	}




	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}




	public String getFoodSize() {
		return foodSize;
	}




	public void setFoodSize(String foodSize) {
		this.foodSize = foodSize;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public List<CartEntity> getCartList() {
		return cartList;
	}




	public void setCartList(List<CartEntity> cartList) {
		this.cartList = cartList;
	}




	@Override
	public String toString() {
		return "FoodEntity [id=" + id + ", foodName=" + foodName + ", foodType=" + foodType + ", foodSize=" + foodSize
				+ ", quantity=" + quantity + ", price=" + price + ", cartList=" + cartList + "]";
	}
	
}


