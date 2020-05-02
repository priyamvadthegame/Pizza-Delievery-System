package com.project.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.UserEntity;
import com.project.entity.UserProfileEntity;
@Component
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	List<UserEntity> findByFirstName(String firstName);
//	List<UserEntity>  findByPassword(String password);
	List<UserEntity>  findByuserId(long id);
	List<UserEntity>  findByUserName(String userName);
		UserProfileEntity save(UserProfileEntity convertUserToUserProfileEntity);
}
