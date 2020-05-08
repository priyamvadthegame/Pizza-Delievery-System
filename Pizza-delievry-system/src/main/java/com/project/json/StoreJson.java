package com.project.json;

public class StoreJson {
	
	
	private long storeId;
	
	
	private String storeName;
	
	
	private String storeStreet;
	
	
	private String storeMobileNo;
	
	
	private String storeCity;
	
	
	private String storeState;
	
	
	private long storePincode;


	public StoreJson() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StoreJson(long storeId, String storeName, String storeStreet, String storeMobileNo, String storeCity,
			String storeState, long storePincode) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeStreet = storeStreet;
		this.storeMobileNo = storeMobileNo;
		this.storeCity = storeCity;
		this.storeState = storeState;
		this.storePincode = storePincode;
	}


	public StoreJson(String storeName, String storeStreet, String storeMobileNo, String storeCity, String storeState,
			long storePincode) {
		super();
		this.storeName = storeName;
		this.storeStreet = storeStreet;
		this.storeMobileNo = storeMobileNo;
		this.storeCity = storeCity;
		this.storeState = storeState;
		this.storePincode = storePincode;
	}


	public long getStoreId() {
		return storeId;
	}


	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreStreet() {
		return storeStreet;
	}


	public void setStoreStreet(String storeStreet) {
		this.storeStreet = storeStreet;
	}


	public String getStoreMobileNo() {
		return storeMobileNo;
	}


	public void setStoreMobileNo(String storeMobileNo) {
		this.storeMobileNo = storeMobileNo;
	}


	public String getStoreCity() {
		return storeCity;
	}


	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}


	public String getStoreState() {
		return storeState;
	}


	public void setStoreState(String storeState) {
		this.storeState = storeState;
	}


	public long getStorePincode() {
		return storePincode;
	}


	public void setStorePincode(long storePincode) {
		this.storePincode = storePincode;
	}


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreJson other = (StoreJson) obj;
		if (storeId != other.storeId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "StoreJson [storeId=" + storeId + ", storeName=" + storeName + ", storeStreet=" + storeStreet
				+ ", storeMobileNo=" + storeMobileNo + ", storeCity=" + storeCity + ", storeState=" + storeState
				+ ", storePincode=" + storePincode + "]";
	}
	
	

}
