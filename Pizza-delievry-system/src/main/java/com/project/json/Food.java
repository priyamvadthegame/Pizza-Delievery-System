package com.project.json;

import java.util.List;

import com.project.entity.CartEntity;

public class Food {

	private long id;
	private String foodName;
	private String foodType;
	private String foodSize;
	private int quantity;
	private double price;
	private List<CartEntity> cartList;
	
	public Food() {
		super();
	}

	public Food(long id, String foodName, String foodType, String foodSize, int quantity, double price,
			List<CartEntity> cartList) {
		super();
		this.id = id;
		this.foodName = foodName;
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
		return "Food [id=" + id + ", foodName=" + foodName + ", foodType=" + foodType + ", foodSize=" + foodSize
				+ ", quantity=" + quantity + ", price=" + price + ", cartList=" + cartList + "]";
	}
	
}

