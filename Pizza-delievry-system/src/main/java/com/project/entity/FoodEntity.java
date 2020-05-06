
package com.project.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOOD_MASTER")
public class FoodEntity {

	@GeneratedValue
	@Id
	@Column(name = "FOOD_ID")
	private long foodId;
	
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
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "foodList")
	private Set<StoreEntity> storeList;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "foodList")
	private List<CartEntity> cartEntity;

public Set<StoreEntity> getStoreList() {
		return storeList;
	}
public void setStoreList(Set<StoreEntity> storeList) {
		this.storeList = storeList;
	}




	public long getFoodId() {
	return foodId;
}
public void setFoodId(long foodId) {
	this.foodId = foodId;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodEntity other = (FoodEntity) obj;
		if (foodId != other.foodId)
			return false;
		return true;
	}




	public FoodEntity() {
		super();
	}




	public FoodEntity(long id, String foodtName, String foodType, String foodSize, int quantity, double price
	) {
		super();
		this.foodId = id;
		this.foodName = foodtName;
		this.foodType = foodType;
		this.foodSize = foodSize;
		this.quantity = quantity;
		this.price = price;

	}



	public long getId() {
		return foodId;
	}




	public void setId(long id) {
		this.foodId = id;
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

public List<CartEntity> getCartEntity() {
		return cartEntity;
	}
	public void setCartEntity(List<CartEntity> cartEntity) {
		this.cartEntity = cartEntity;
	}
	@Override
	public String toString() {
		return "FoodEntity [id=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", foodSize=" + foodSize
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}


