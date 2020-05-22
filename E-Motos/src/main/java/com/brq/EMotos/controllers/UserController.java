package com.brq.EMotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.User;
import com.brq.EMotos.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository ur;
	
	@GetMapping("/showUser/{id}")
	public User showUser(@PathVariable int id) {
		User showUser = ur.findById(id);
		return showUser;
	}
	
	@GetMapping("/listUsers")
	public Iterable<User> listUsers() {
		try {
			Iterable<User> listUsers = ur.findAll();
			return listUsers;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@PostMapping(value = "/createUser")
	public User createUser (@RequestBody User user){
		try {
			User newUser = ur.save(user);
			return newUser;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new User();
	}
	
	@PutMapping(value = "updateUser/{id}")
	public User updateUser (@PathVariable int id, @RequestBody User user){
		try {
			User findedUser = ur.findById(id);
			user.setId(id);
			findedUser = user;
			ur.save(findedUser);
			return findedUser;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	@DeleteMapping(value = "deleteUser/{id}")
	public String deleteUser(@PathVariable int id){
		try {
			User findedUser = ur.findById(id);
			System.out.println(findedUser.getId());
			ur.delete(findedUser);
			return "Moto id:" + id + " successfully deleted!";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
}









