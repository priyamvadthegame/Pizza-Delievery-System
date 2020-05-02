package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_entity")
public class OrderEntity {
	
	@GeneratedValue
	@Id
	@Column(name = "id")
	private long orderId;
	
	@ManyToOne
	@JoinColumn(name = "storeId")
	private StoreEntity storeId;
	
	@Column(name = "status")
	private String orderStatus;
	
	@Column(name = "street")
	private String Street;

	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private long pincode;
	
	@Column(name = "mobile")
	private int mobileNo;
	
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private UserEntity userId;
	
	
	@OneToOne(targetEntity = CartEntity.class)
	private CartEntity cartId;

	public OrderEntity() {
		super();
		
	}

	public OrderEntity( String orderStatus, String street, String city, String state, long pincode,
			int mobileNo) {
		super();
		this.orderStatus = orderStatus;
		Street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public StoreEntity getStoreId() {
		return storeId;
	}

	public void setStoreId(StoreEntity storeId) {
		this.storeId = storeId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public CartEntity getCartId() {
		return cartId;
	}

	public void setCartId(CartEntity cartId) {
		this.cartId = cartId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", storeId=" + storeId + ", orderStatus=" + orderStatus + ", Street="
				+ Street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo=" + mobileNo
				+ ", userId=" + userId + ", cartId=" + cartId + "]";
	}
	
	
	
	

}
