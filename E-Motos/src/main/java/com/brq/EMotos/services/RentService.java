package com.brq.EMotos.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.EMotos.models.Address;
import com.brq.EMotos.models.Moto;
import com.brq.EMotos.models.Rent;
import com.brq.EMotos.models.User;
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
    
    public static long calcPrice(int rentalOptionByKm, float pricePerKm, boolean helmet) {
    	if(helmet)
    		return (long) (pricePerKm * rentalOptionByKm + 20.00);
    	else
    		return (long) (pricePerKm * rentalOptionByKm);
    }
    
	public Rent releaseRent(int idRent) {
		if(idRent > 0) {
			Rent rentFinded = rr.findById(idRent);
			User userFinded = userService.findUserById(rentFinded.getUserRentId().getId());
			Moto motoFinded = motoService.findMotoById(rentFinded.getMotoRentId().getId());
			
			if(rentFinded != null || userFinded != null || motoFinded != null) {

				userFinded.setStatusRentUser(false);
				userFinded.setRentProtocol(null);
				userService.updateUser(userFinded.getId(), userFinded);
				
				motoFinded.setStatusRent(false);
				motoService.updateMoto(motoFinded.getId(), motoFinded);
				
				rentFinded.setActiveContract(false);
				return rr.save(rentFinded);
			}
		}
		return null;
	}    
	
	public Rent findRent(int idUserLoged) {
		User userLoged = userService.findUserById(idUserLoged);
		
		Rent rentFinded = rr.findByProtocol(userLoged.getRentProtocol());
		
		if(rentFinded != null)
			return rentFinded;
		else
			return null;
	}
	
	public Iterable<Rent> findAllRent() {
		Iterable<Rent> listRent = rr.findAll();
		if(listRent != null)
			return listRent;
		else
			return null;
	}
	
	public Rent createRent(Rent rent) {
		
        User userFinded = userService.findUserById(rent.getUserRentId().getId());
        
        Moto motoFinded = motoService.findMotoById(rent.getMotoRentId().getId());
        
        if(rent.getCreditCardRentId() == null ||
        		userFinded == null || motoFinded == null || 
        		motoFinded.getStatusRent() == true ||
        		userFinded.getStatusRentUser() == true ||
        		(!rent.isPickGarage() && rent.getAddressReceivementId() == null) ||
        		(!rent.isTurnOverGarage() && rent.getAddressRemovalId() == null)){
        	
        	return null;
        }
        
        rent.setActiveContract(true);
        rent.setMotoRentId(motoFinded);
        rent.setUserRentId(userFinded);
        rent.setCreditCardRentId(cr.save(rent.getCreditCardRentId()));
        rent.setProtocol(shuffle(motoFinded.getLicensePlate() + userFinded.getCpf()));
        
    	// address defaut
    	//R. Boa Vista, 254 - Centro Histórico de São Paulo, São Paulo - SP, 01014-000
        Address addressDeault = ar.save(new Address("01014-000", "Centro Histórico",
        	254, "São Paulo", "SP", "R. Boa Vista", null));
        
        //AddressReceivement
        if(!rent.isPickGarage() && rent.getAddressReceivementId() != null) {
            Address addressRentReceivement = ar.save(rent.getAddressReceivementId());
            rent.setAddressReceivementId(addressRentReceivement);
        }else {
            rent.setAddressReceivementId(addressDeault);
        } 
            
        //AddressRemoval
        if(!rent.isTurnOverGarage() && rent.getAddressRemovalId() != null) {
            Address addressRentRemoval = ar.save(rent.getAddressRemovalId());
            rent.setAddressRemovalId(addressRentRemoval);
        }else {
            rent.setAddressRemovalId(addressDeault);
        }
        
        rent.setFinalPrice(calcPrice(rent.getRentalOptionByKm(), 
        	motoFinded.getPricePerKm(), rent.isHelmet()));
        
        motoFinded.setStatusRent(true);
        motoService.updateMoto(motoFinded.getId(), motoFinded);
        
        userFinded.setStatusRentUser(true);
        userFinded.setRentProtocol(rent.getProtocol());
        userService.updateUser(userFinded.getId(), userFinded);
        
        return rr.save(rent);
	}
	
	public String deleteRent(int idRent) {
		Rent rentReleased = releaseRent(idRent);
		if(rentReleased != null) {
			rr.delete(rentReleased);
			return "deleted!";
		}else {
			return null;
		}
	}
	
}
