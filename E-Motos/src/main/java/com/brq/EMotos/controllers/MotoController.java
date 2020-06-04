package com.brq.EMotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.Moto;
import com.brq.EMotos.repository.MotoRepository;

@RestController
@RequestMapping("/moto")
public class MotoController {

	@Autowired
	private static MotoRepository mr;
	
	@CrossOrigin
	@GetMapping("/showMoto/{id}")
	public Moto showMoto (@PathVariable int id) {
		Moto showMoto = mr.findById(id);
		return showMoto;
	}
	
	@CrossOrigin
	@GetMapping("/listMotos")
	public Iterable<Moto> listMotos() {
		try {
			Iterable<Moto> listMotos = mr.findAll();
			return listMotos;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@CrossOrigin
	@PostMapping(value = "/createMoto")
	public Moto createMoto (@RequestBody Moto moto){
		try {
			Moto newMoto = mr.save(moto);
			return newMoto;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	@CrossOrigin
	@PutMapping(value = "updateMoto/{id}")
	public static Moto updateMoto (@PathVariable int id, @RequestBody Moto moto){
		try {
			Moto findedMoto = mr.findById(id);
			moto.setId(id);
			findedMoto = moto;
			mr.save(findedMoto);
			return findedMoto;
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
		return null;
	}
	
	@CrossOrigin
	@DeleteMapping(value = "deleteMoto/{id}")
	public String deleteMoto (@PathVariable int id){
		try {
			Moto findedMoto = mr.findById(id);
			mr.delete(findedMoto);
			return "Moto id:" + id + " successfully deleted!";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
}









