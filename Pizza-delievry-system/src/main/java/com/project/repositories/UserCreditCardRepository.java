package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CreditCardEntity;

public interface UserCreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
	
	List<CreditCardEntity>findByCreditCardNumber(String creditCardNumber);

}
