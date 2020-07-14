package com.brq.EMotos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.EMotos.models.Address;
import com.brq.EMotos.models.User;
import com.brq.EMotos.repository.AddressRepository;
import com.brq.EMotos.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	// trocar pelo service de Address
	@Autowired
	private AddressRepository ar;
	
	
	public User findUserById(int id)  {
		User showUser = ur.findById(id);
		if(showUser != null)
			return showUser;
		else 
			return null;
	}
	
	public Iterable<User> findAllUser()  {
		Iterable<User> listUsers = ur.findAll();
		if(listUsers != null)
			return listUsers;
		else
			return null;
	}
	
	public User createUser(User user)  {
		Address addressUser = user.getAddressUser();
		
		if(addressUser != null) {
			user.setAddressUser(ar.save(addressUser));
			user.setStatusRentUser(false);
            user.setType("client");
           
            return ur.save(user);
		}
		return null;
	}
	
	public User updateUser(int id, User userModified) {
		User findedUser = ur.findById(id);
		if(findedUser != null) {
			userModified.setAddressUser(ar.save(userModified.getAddressUser()));
			userModified.setId(id);
			return ur.save(userModified);
		}else {
			return null;
		}
	}
	
	public String deleteUser(int id) {
		User findedUser = ur.findById(id);
		if(findedUser != null) {
			ur.delete(findedUser);
			return "deleted!";
		}else {
			return null;
		}
	}
	
	
}
