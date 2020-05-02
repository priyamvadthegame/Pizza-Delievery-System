package com.project.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cart_entity")
public class CartEntity {
	

	@GeneratedValue
	@Id
	@Column(name = "cart_id")
	private long cartId;
	
	@Column(name = "cart_quantity")
	private int quantity;

	@Column(name = "food_type")
	private String type;
	
	@Column(name="cart_price")
	private int price;
	
	@Column(name = "food_id")
	private int foodId;
	
	@ManyToMany(fetch = FetchType.LAZY,
		    cascade = {
		        CascadeType.PERSIST,
		        CascadeType.MERGE
		    })
		@JoinTable(name = "cart_food_table",joinColumns = {@JoinColumn(name = "cart_id")},inverseJoinColumns= {@JoinColumn(name ="food_id")})

    private List<FoodEntity> foodList;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne(targetEntity =OrderEntity.class)
	private OrderEntity order;
	
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
	
	public List<FoodEntity> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodEntity> foodList) {
		this.foodList = foodList;
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

	

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
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
