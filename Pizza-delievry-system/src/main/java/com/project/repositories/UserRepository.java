package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.UserEntity;


@Component
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserId(long userId);
	UserEntity findBySessionId(String authToken);
	UserEntity deleteBySessionId(String authToken);
}
