package com.store.api.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.store.api.entity.StoreEntity;
import com.store.api.repository.StoreRepository;

/**
 * Service layer to communicate with repository layer
 * for Store transactions
 * @author maneendra.yarru
 *
 */
@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;

	public Boolean createStore(StoreEntity store) {
		Integer storeId = (storeRepository.save(store)).getStoreId();
		if(storeId > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Service to return Stores based on storeName
	 * @param storeName
	 * @return All Stores if storeName is empty
	 */
	public List<StoreEntity> getStores(String storeName) {
		if (!StringUtils.isBlank(storeName)) {
			return storeRepository.findStoresByName(storeName);
		} else {
			return storeRepository.findAll(Sort.by(Sort.Direction.DESC, "storeName"));
		}
	}

	/**
	 * find stores based on Location(ltd, lng)
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public List<StoreEntity> getStoresByLocation(Float latitude, Float longitude) {
		return storeRepository.findStoresByLocation(latitude, longitude);
	}

}
