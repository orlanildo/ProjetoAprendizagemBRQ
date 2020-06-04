package com.brq.EMotos.controllers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.Address;
import com.brq.EMotos.models.Rent;
import com.brq.EMotos.repository.AddressRepository;
import com.brq.EMotos.repository.CreditCardRepository;
import com.brq.EMotos.repository.RentRepository;

@RestController
public class RentController {
	
	/*
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private MotoRepository mr;
	*/
	
	@Autowired
	private RentRepository rr;
	
	@Autowired
	private CreditCardRepository cr;
	
	@Autowired
	private AddressRepository ar;
	
	
	public static String shuffle(String s) {
	    List<Character> letters = s.chars().boxed().map(c -> (char) c.intValue()).collect(Collectors.toList());
	    Collections.shuffle(letters);
	    StringBuilder t = new StringBuilder(s.length());
	    letters.forEach(t::append);
	    return t.toString();
	}
	
	
	
	@CrossOrigin
    @PostMapping(value ="/pagamento")
    public Rent efetuarPagamento(@RequestBody Rent rent) {
    	try {
    		    	
    		//AddressReceivement
    		if(!rent.isPickGarage()) {
    			if(rent.getAddressReceivementId() != null) {
    				Address addressRentReceivement = ar.save(rent.getAddressReceivementId());
    				rent.setAddressReceivementId(addressRentReceivement);
    			}
    		}else {
    			rent.setAddressReceivementId(rent.getUserRentId().getAddressUser());
    		} 
    			
    		//AddressRemoval
    		if(!rent.isTurnOverGarage()) {
    			if(rent.getAddressRemovalId() != null) {
    				Address addressRentRemoval = ar.save(rent.getAddressRemovalId());
    				rent.setAddressRemovalId(addressRentRemoval);
    			}
    		}else {
    			rent.setAddressRemovalId(rent.getUserRentId().getAddressUser());
    		}
    		
    		//CreditCar
    		if(rent.getCreditCardRentId() != null) {
    			rent.setCreditCardRentId(cr.save(rent.getCreditCardRentId()));
    		}
    		
    		// Usar os methodos dos controllers de user e moto para atualizar 
    		// os status dos mesmos OU criara um novo methodo para fazer isso 
    		
    		//Moto
    		if(rent.getMotoRentId().getStatusRent().equals("rent")) {
        		MotoController.updateMoto(rent.getMotoRentId().getId(), rent.getMotoRentId());
    		}
    		
    		//User
    		if(rent.getUserRentId().getStatusRentUser().equals("rented")) {
    			UserController.updateUser(rent.getUserRentId().getId(), rent.getUserRentId());
    		}
    		
    		String protocol = rent.getMotoRentId().getLicensePlate() + rent.getUserRentId().getCpf();
    		
    		rent.setProtocol(protocol);
    		
			Rent newRent = rr.save(rent);
    		
    		return newRent;
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
    	
    	return null;
    }
	
}









