package com.project.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.CartEntity;

@Component
public interface UserCartRepository extends JpaRepository<CartEntity, Long> {
	List<CartEntity> findByCartId(long cartId);
	List<CartEntity> findByfoodId(long foodId);
	


}
