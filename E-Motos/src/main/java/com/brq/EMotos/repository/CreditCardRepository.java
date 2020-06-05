package com.brq.EMotos.repository;

import org.springframework.data.repository.CrudRepository;

import com.brq.EMotos.models.CreditCard;

public interface CreditCardRepository extends CrudRepository<CreditCard, String> {
	
	CreditCard findById(int id);
}
