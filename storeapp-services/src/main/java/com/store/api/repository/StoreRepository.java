package com.store.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.api.entity.StoreEntity;

/**
 * 
 * @author maneendra.yarru
 * Repository to perform transactions on StoreEntity
 *
 */

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {

	/**
	 * find Stores based on storeName
	 * @param storeName
	 * @return
	 */
	@Query("FROM StoreEntity WHERE storeName = :storeName")
	public List<StoreEntity> findStoresByName(@Param("storeName") String storeName);

	/**
	 * find near by Stores based on given location(ltd, lng) 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	@Query("FROM StoreEntity WHERE (6371 * ACOS(COS(RADIANS(:latitude)) * COS(RADIANS(latitude)) * COS(RADIANS(longitude) - RADIANS(:longitude)) + SIN(RADIANS(:latitude)) * SIN(RADIANS(latitude)))) < 10 ")
	public List<StoreEntity> findStoresByLocation(@Param("latitude") Float latitude,
			@Param("longitude") Float longitude);

}
