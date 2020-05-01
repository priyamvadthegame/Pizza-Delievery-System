package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.CreditCardEntity;
@Component
public interface UserCreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
	
	List<CreditCardEntity>findByCreditCardNumber(String creditCardNumber);

}
