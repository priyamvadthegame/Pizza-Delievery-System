package com.project.json;

public class StoreJson {
	
	
	private long storeId;
	
	
	private String storeName;
	
	
	private String storeStreet;
	
	
	private int storeMobileNo;
	
	
	private String storeCity;
	
	
	private long storeState;
	
	
	private long storePincode;


	public StoreJson() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StoreJson(long storeId, String storeName, String storeStreet, int storeMobileNo, String storeCity,
			long storeState, long storePincode) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeStreet = storeStreet;
		this.storeMobileNo = storeMobileNo;
		this.storeCity = storeCity;
		this.storeState = storeState;
		this.storePincode = storePincode;
	}


	public StoreJson(String storeName, String storeStreet, int storeMobileNo, String storeCity, long storeState,
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


	public int getStoreMobileNo() {
		return storeMobileNo;
	}


	public void setStoreMobileNo(int storeMobileNo) {
		this.storeMobileNo = storeMobileNo;
	}


	public String getStoreCity() {
		return storeCity;
	}


	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}


	public long getStoreState() {
		return storeState;
	}


	public void setStoreState(long storeState) {
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
