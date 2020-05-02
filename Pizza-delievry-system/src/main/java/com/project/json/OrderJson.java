package com.project.json;



public class OrderJson {
	

    private long orderId;
	
	private long storeId;
	
	
	private String orderStatus;
	
	private long Street;

	
	private long city;
	
	
	private long state;
	
	
	private long pincode;
	
	
	private int mobileNo;
	

	public OrderJson() {
		super();
		
	}


	public OrderJson(long storeId, String orderStatus, long street, long city, long state, long pincode, int mobileNo) {
		super();
		this.storeId = storeId;
		this.orderStatus = orderStatus;
		Street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
	}


	public OrderJson(long orderId, long storeId, String orderStatus, long street, long city, long state, long pincode,
			int mobileNo) {
		super();
		this.orderId = orderId;
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



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderJson other = (OrderJson) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "OrderJson [orderId=" + orderId + ", storeId=" + storeId + ", orderStatus=" + orderStatus + ", Street="
				+ Street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo=" + mobileNo
				+ "]";
	}

	

}
