package com.project.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.StoreEntity;


@Component
public interface StoreRepository extends JpaRepository<StoreEntity,Long> {
	List<StoreEntity> findByStoreId(long id);
}
