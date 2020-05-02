package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class OrderEntity {
	
	@GeneratedValue
	@Id
	@Column(name = "")
	private long orderId;
	
	@Column(name = "")
	private long storeId;
	
	@Column(name = "")
	private String orderStatus;
	
	@Column(name = "")
	private long Street;

	@Column(name = "")
	private long city;
	
	@Column(name = "")
	private long state;
	
	@Column(name = "")
	private long pincode;
	
	@Column(name = "")
	private int mobileNo;
	
	@Column(name = "")
	@ManyToOne
	private UserEntity userId;
	
	@Column(name = "")
	@OneToOne
	private CartEntity cartId;

	public OrderEntity() {
		super();
		
	}

	public OrderEntity(long storeId, String orderStatus, long street, long city, long state, long pincode,
			int mobileNo) {
		super();
		this.storeId = storeId;
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

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getStreet() {
		return Street;
	}

	public void setStreet(long street) {
		Street = street;
	}

	public long getCity() {
		return city;
	}

	public void setCity(long city) {
		this.city = city;
	}

	public long getState() {
		return state;
	}

	public void setState(long state) {
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
