package com.project.json;



public class OrderJson {
	

    private long orderId;
	

	
	
	
	private String orderStatus;
	
	private String Street;

	
	private String city;
	
	
	private String state;
	
	
	private long pincode;
	
	
	private String mobileNo;
	

	public OrderJson() {
		super();
		
	}


	public OrderJson( String orderStatus, String street, String city, String state, long pincode, String mobileNo) {
		super();
		
		this.orderStatus = orderStatus;
		Street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
	}


	public OrderJson(long orderId,  String orderStatus, String street, String city, String state, long pincode,
			String mobileNo) {
		super();
		this.orderId = orderId;
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


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
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
		return "OrderJson [orderId=" + orderId + ", orderStatus=" + orderStatus + ", Street="
				+ Street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo=" + mobileNo
				+ "]";
	}

	

}
