package com.brq.EMotos.repository;

import org.springframework.data.repository.CrudRepository;

import com.brq.EMotos.models.Rent;

public interface RentRepository extends CrudRepository<Rent, String> {
	
	Rent findById(int id);

	Rent findByProtocol(String protocol);
}
