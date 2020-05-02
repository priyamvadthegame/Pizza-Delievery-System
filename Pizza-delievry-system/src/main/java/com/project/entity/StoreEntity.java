package com.project.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class StoreEntity {
	
	@GeneratedValue
	@Id
	@Column(name = "")
	private long storeId;
	
	@Column(name = "")
	private String storeName;
	
	@Column(name = "")
	private String storeStreet;
	
	@Column(name = "")
	private int storeMobileNo;
	
	@Column(name = "")
	private String storeCity;
	
	@Column(name = "")
	private long storeState;
	
	@Column(name = "")
	private long storePincode;
	
	@ManyToMany
	private Set<FoodEntity> foodList;

	public StoreEntity() {
		super();
		
	}

	public StoreEntity(String storeName, String storeStreet, int storeMobileNo, String storeCity, long storeState,
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

	public Set<FoodEntity> getFoodList() {
		return foodList;
	}

	public void setFoodList(Set<FoodEntity> foodList) {
		this.foodList = foodList;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreEntity other = (StoreEntity) obj;
		if (storeId != other.storeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StoreEntity [storeId=" + storeId + ", storeName=" + storeName + ", storeStreet=" + storeStreet
				+ ", storeMobileNo=" + storeMobileNo + ", storeCity=" + storeCity + ", storeState=" + storeState
				+ ", storePincode=" + storePincode + ", foodList=" + foodList + "]";
	}
	
	
	
	
	

}
