package com.brq.EMotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.Rent;
import com.brq.EMotos.services.RentService;


@CrossOrigin
@RestController
@RequestMapping("/rent")
public class RentController {
    
	@Autowired
    private RentService rentService;
    
	@GetMapping("/showRent")
	public ResponseEntity<?> showRent(@RequestAttribute("idUserLoged") int idUserLoged){
		Rent rent = rentService.findRent(idUserLoged);
		if(rent != null) 
			return ResponseEntity.ok(rent);
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listRent")
	public ResponseEntity<?> listRent() {
		if(rentService.findAllRent() != null) 
			return ResponseEntity.ok(rentService.findAllRent());
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/releaseRent/{id}")
    public ResponseEntity<?> releaseRent(@PathVariable int id) {
		Rent releaseRent = rentService.releaseRent(id);
		if(releaseRent != null) 
			return ResponseEntity.ok(releaseRent);
		else
			return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/createRent")
    public Rent createRent(@RequestBody Rent rent) {
    	
    	return rentService.createRent(rent);
    }
    
}