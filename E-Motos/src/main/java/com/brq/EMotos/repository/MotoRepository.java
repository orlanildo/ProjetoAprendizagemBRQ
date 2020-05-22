package com.brq.EMotos.repository;

import org.springframework.data.repository.CrudRepository;

import com.brq.EMotos.models.Moto;

public interface MotoRepository extends CrudRepository<Moto, String> {
	Moto findById(int id);
}
