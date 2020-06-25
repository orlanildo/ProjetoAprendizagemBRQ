package com.brq.EMotos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.brq.EMotos.services.MotoService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/moto")
public class MotoController {

	@Autowired
	private MotoService motoService;
	
	
	@GetMapping("/showMoto/{id}")
	public ResponseEntity<?> showMoto (@PathVariable int id) {
		if(motoService.findMotoById(id) != null) 
			return ResponseEntity.ok(motoService.findMotoById(id));
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listMotos")
	public ResponseEntity<?> listMotos() {
		//Iterable<Moto> motoFinded = motoService.findAllMoto();
		if(motoService.findAllMoto() != null) 
			return ResponseEntity.ok(motoService.findAllMoto());
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping(value = "/createMoto")
	public ResponseEntity<?> createMoto (@RequestBody Moto moto){
		if(motoService.createMoto(moto) != null) 
			return ResponseEntity.ok(motoService.createMoto(moto));
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value = "updateMoto/{id}")
	public ResponseEntity<?> updateMoto (@PathVariable int id, @RequestBody @Valid Moto moto){
		if(motoService.updateMoto(id, moto) != null) 
			return ResponseEntity.ok(motoService.updateMoto(id, moto));
		else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "deleteMoto/{id}")
	public ResponseEntity<?> deleteMoto (@PathVariable int id){
		if(motoService.deleteMoto(id) != null) 
			return ResponseEntity.ok(motoService.deleteMoto(id));
		else
			return ResponseEntity.notFound().build();
	}
	
}









