package com.store.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.entity.StoreEntity;
import com.store.api.service.StoreService;

/**
 * 
 * @author maneendra.yarru
 * Controller class for Store API Management
 * 
 */
@RestController
@RequestMapping("/api/store")
public class StoreApiController {
	
	private static final Logger logger = LoggerFactory.getLogger(StoreApiController.class);
	
	@Autowired
	private StoreService storeService;
	
	/**
	 * API to create Store
	 * @param StoreEntity as request body
	 */
	@PostMapping("/create")
	public Boolean createStore(@RequestBody StoreEntity store) {
		logger.debug("StoreApiController :: createStore");
		return storeService.createStore(store);
	}
	
	/**
	 * API to find stores by name
	 * @param storeName
	 * @return List of StoreEntity based on storeName, and All Stores if input storeName is empty
	 */
	@GetMapping("/getStores")
	public List<StoreEntity> getStores(@RequestParam("storeName") String storeName) {
		logger.debug("StoreApiController :: getStoresByName");
		return storeService.getStores(storeName);
	}
	
	/**
	 * API to find stores by location
	 * @param longitude
	 * @param latitude
	 * @return List of StoreEntities
	 * 		or empty if no stores found
	 */
	@GetMapping("/getStoresByLocation/lat/{lat}/lng/{lng}")
	public List<StoreEntity> getStoresByLocation(@PathVariable("lat") Float latitude, @PathVariable("lng") Float longitude) {
		logger.debug("StoreApiController :: getStoresByLocation");
		return storeService.getStoresByLocation(latitude, longitude);
	}
	
}
