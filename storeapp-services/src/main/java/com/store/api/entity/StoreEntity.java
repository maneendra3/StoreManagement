package com.store.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for Store table 
 * @author maneendra.yarru
 *
 */
@Entity
@Table(name = "store")
public class StoreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeId;
	private String storeName;
	private String category;
	private String storeAddress;
	private Float latitude;
	private Float longitude;
	private String ownerName;

	public StoreEntity() {
		super();
	}

	public StoreEntity(String storeName, String category, String storeAddress, Float latitude, Float longitude, String ownerName) {
		super();
		this.storeName = storeName;
		this.category = category;
		this.storeAddress = storeAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ownerName = ownerName;
	}

	public StoreEntity(Integer storeId, String storeName, String category, String storeAddress, Float latitude, Float longitude,
			String ownerName) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.category = category;
		this.storeAddress = storeAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ownerName = ownerName;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
