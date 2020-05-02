package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.UserProfileEntity;

@Component
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
	
	List<UserProfileEntity> findByUserId(long userId);

}
