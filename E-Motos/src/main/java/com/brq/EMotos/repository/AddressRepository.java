package com.brq.EMotos.repository;

import org.springframework.data.repository.CrudRepository;

import com.brq.EMotos.models.Address;

public interface AddressRepository extends CrudRepository<Address, String> {
	
	Address findById(int id);
}
