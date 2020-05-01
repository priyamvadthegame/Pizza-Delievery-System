package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import com.project.entity.UserEntity;

@Component
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	List<UserEntity> findByLoginstatus(String sessionId);
	List<UserEntity> findByUserId(long userId);
	List<UserEntity> findByUsername(String username);
}
