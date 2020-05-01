package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	List<UserEntity> findByLoginstatus(String sessionId);

}
