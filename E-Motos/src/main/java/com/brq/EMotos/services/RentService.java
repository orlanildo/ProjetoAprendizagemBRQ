package com.brq.EMotos.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.EMotos.models.Address;
import com.brq.EMotos.models.Rent;
import com.brq.EMotos.repository.AddressRepository;
import com.brq.EMotos.repository.CreditCardRepository;
import com.brq.EMotos.repository.RentRepository;


@Service
public class RentService {

	@Autowired
	private RentRepository rr;
    
    @Autowired
    private CreditCardRepository cr;
    
    @Autowired
    private AddressRepository ar;
	
	@Autowired
	private MotoService motoService;
	
	@Autowired
	private UserService userService;
	
	
    public static String shuffle(String s) {
        List<Character> letters = s.chars().boxed().map(c -> (char) c.intValue())
        	.collect(Collectors.toList());
        Collections.shuffle(letters);
        StringBuilder t = new StringBuilder(s.length());
        letters.forEach(t::append);
        return t.toString();
    }
	
	public Rent findRent(int idUserLoged)  {
		int idRentOfUser = userService.findUserById(idUserLoged).getRentId().getId();
		if(rr.findById(idRentOfUser) != null)
			return rr.findById(idRentOfUser);
		else
			return null;
	}
	
	public Iterable<Rent> findAllRent()  {
		if(rr.findAll() != null)
			return rr.findAll();
		else
			return null;
	}
	
	public Rent createRent(Rent rent)  {
		
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
                    
        //Moto
        if(rent.getMotoRentId().getStatusRent().equals("rent")) {
        	motoService.updateMoto(rent.getMotoRentId().getId(), rent.getMotoRentId());
        }
        
        //User
        if(rent.getUserRentId().getStatusRentUser().equals("rented")) {
        	userService.updateUser(rent.getUserRentId().getId(), rent.getUserRentId());
        }
        
        String protocol = rent.getMotoRentId().getLicensePlate() + rent.getUserRentId().getCpf();
        
        rent.setProtocol(shuffle(protocol));
        
        return rr.save(rent);
        
	}
	
}
