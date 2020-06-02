package com.brq.EMotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.Address;
import com.brq.EMotos.models.Moto;
import com.brq.EMotos.models.Rent;
import com.brq.EMotos.repository.AddressRepository;
import com.brq.EMotos.repository.CreditCardRepository;
import com.brq.EMotos.repository.MotoRepository;
import com.brq.EMotos.repository.RentRepository;
import com.brq.EMotos.repository.UserRepository;


@RestController
public class RentController {

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private MotoRepository mr;
	
	@Autowired
	private RentRepository rr;
	
	@Autowired
	private CreditCardRepository cr;
	
	@Autowired
	private AddressRepository ar;
	
	
	public Moto motoChosen;
	

	
	// trazer o user que está na sessão, validar e setalo no UserRentId
	// trazer a moto que o cliente selecionou e setala no MotoRentIdRentId
	
	@CrossOrigin
    @PostMapping(value ="/pagamento")
    public Rent efetuarPagamento(@RequestBody Rent rent) {
    	try {
    		    		
    		if(!rent.isPickGarage()) {
    			if(rent.getAddressReceivementId() != null) {
    				Address addressRentReceivement = ar.save(rent.getAddressReceivementId());
    				rent.setAddressReceivementId(addressRentReceivement);
    			}
    		}else {
    			rent.setAddressReceivementId(null);
    		} 
    			
    		if(!rent.isTurnOverGarage()) {
    			if(rent.getAddressRemovalId() != null) {
    				Address addressRentRemoval = ar.save(rent.getAddressRemovalId());
    				rent.setAddressRemovalId(addressRentRemoval);
    			}
    		}else {
    			rent.setAddressRemovalId(null);
    		}
    		
    		if(rent.getCreditCardRentId() != null) {
    			rent.setCreditCardRentId(cr.save(rent.getCreditCardRentId()));
    		}
    		
			Rent newRent = rr.save(rent);
    		
    		return newRent;
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
    	
    	return null;
    }
	
}









