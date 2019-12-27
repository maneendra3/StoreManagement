package com.store.api.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.api.entity.StoreEntity;
import com.store.api.service.StoreService;

@RunWith(SpringRunner.class)
public class StoreApiControllerTest {

	@InjectMocks
	private StoreApiController storeApiController;
	
	@Mock
	private StoreService storeService;
	
	@Test
	public void createStoreTest() {
		StoreEntity store = new StoreEntity("store1", "Mall", "Madhapur", 17.1f, 78.1f, "Owner");
		when(storeService.createStore(Mockito.any())).thenReturn(true);
		Boolean result = storeApiController.createStore(store);
		assertTrue(result);
	}
	
	@Test
	public void getStoresTest() {
		String storeName = "store1";
		when(storeService.getStores(Mockito.anyString())).thenReturn(new ArrayList<StoreEntity>());
		List<StoreEntity> response = storeApiController.getStores(storeName);
		assertEquals(new ArrayList<StoreEntity>(), response);
	}
	
	@Test
	public void getStoresByLocationTest() {
		when(storeService.getStoresByLocation(Mockito.anyFloat(), Mockito.anyFloat())).thenReturn(new ArrayList<StoreEntity>());
		List<StoreEntity> response = storeApiController.getStoresByLocation(17.1f, 78.1f);
		assertEquals(new ArrayList<StoreEntity>(), response);
	}
	
}
