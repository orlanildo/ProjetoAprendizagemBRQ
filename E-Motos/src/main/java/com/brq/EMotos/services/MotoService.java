package com.brq.EMotos.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.EMotos.models.Moto;
import com.brq.EMotos.repository.MotoRepository;


@Service
public class MotoService {

	@Autowired
	private MotoRepository mr;
	
	
	public Moto findMotoById(int id)  {
		Moto showMoto = mr.findById(id);
		if(showMoto != null)
			return showMoto;
		else 
			return null;
	}
	
	public Iterable<Moto> findAllMoto()  {
		Iterable<Moto> listMotos = mr.findAll();
		if(listMotos != null)
			return listMotos;
		else
			return null;
	}
	
	public Moto createMoto(@Valid Moto moto)  {
		Moto motoCreated = mr.save(moto);
		if(motoCreated != null)
			return motoCreated;
		else
			return null;
	}
	
	public Moto updateMoto(int id, @Valid Moto motoModified) {
		Moto findedMoto = mr.findById(id);
		if(findedMoto!= null) {
			motoModified.setId(id);
			return mr.save(motoModified);
		}else {
			return null;
		}
	}
	
	public String deleteMoto(int id) {
		Moto findedMoto = mr.findById(id);
		if(findedMoto != null) {
			mr.delete(findedMoto);
			return "deleted!";
		}else {
			return null;
		}
	}
	
}
