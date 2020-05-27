package com.brq.EMotos.repository;

import org.springframework.data.repository.CrudRepository;

import com.brq.EMotos.models.User;

public interface UserRepository extends CrudRepository<User, String> {

	User findById(int id);
	
	User findByEmail(String email);
}
