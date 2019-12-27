package com.store.api.service;

import static org.junit.Assert.assertFalse;
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
import com.store.api.repository.StoreRepository;

@RunWith(SpringRunner.class)
public class StoreServiceTest {
	
	@InjectMocks
	private StoreService storeService;
	
	@Mock
	private StoreRepository storeRepository;
	
	@Test
	public void createStoreTest() {
		StoreEntity store = new StoreEntity(1, "store1", "Mall", "Madhapur", 17.1f, 78.1f, "Owner");
		when(storeRepository.save(Mockito.any())).thenReturn(store);
		Boolean result = storeService.createStore(store);
		assertTrue(result);
	}
	
	@Test
	public void createStoreFailureTest() {
		StoreEntity store = new StoreEntity(0, "store1", "Mall", "Madhapur", 17.1f, 78.1f, "Owner");
		when(storeRepository.save(Mockito.any())).thenReturn(store);
		Boolean result = storeService.createStore(store);
		assertFalse(result);
	}
	
	@Test
	public void getStoresTest() {
		String storeName = "";
		when(storeRepository.findAll()).thenReturn(new ArrayList<StoreEntity>());
		List<StoreEntity> response = storeService.getStores(storeName);
		assertEquals(new ArrayList<StoreEntity>(), response);
	}
	
	@Test
	public void getStoresByStoreNameTest() {
		String storeName = "store1";
		when(storeRepository.findStoresByName(Mockito.anyString())).thenReturn(new ArrayList<StoreEntity>());
		List<StoreEntity> response = storeService.getStores(storeName);
		assertEquals(new ArrayList<StoreEntity>(), response);
	}
	
	@Test
	public void getStoresByLocationTest() {
		when(storeRepository.findStoresByLocation(Mockito.anyFloat(), Mockito.anyFloat())).thenReturn(new ArrayList<StoreEntity>());
		List<StoreEntity> response = storeService.getStoresByLocation(17.1f, 78.1f);
		assertEquals(new ArrayList<StoreEntity>(), response);
	}

}
