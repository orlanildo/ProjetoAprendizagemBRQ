package com.brq.EMotos.controllers;

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

import com.brq.EMotos.models.User;
import com.brq.EMotos.services.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
		
	
	@GetMapping("/showUser/{id}")
	public ResponseEntity<?> showUser(@PathVariable int id){
		if(userService.findUserById(id) != null) 
			return ResponseEntity.ok(userService.findUserById(id));
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listUsers")
	public ResponseEntity<?> listUsers(){
		if(userService.findAllUser() != null) 
			return ResponseEntity.ok(userService.findAllUser());
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser (@RequestBody User user){
		if(userService.createUser(user) != null)
			return ResponseEntity.ok(userService.createUser(user));
		else
			return ResponseEntity.notFound().build();
	}	
	
	@PutMapping("updateUser/{id}")
	public ResponseEntity<?> updateUser (@PathVariable int id, @RequestBody User user) {
		if(userService.updateUser(id, user) != null)
			return ResponseEntity.ok(userService.updateUser(id, user));
		else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		if(userService.deleteUser(id) != null)
			return ResponseEntity.ok("Usuario ID: " + id + " successfully deleted!");
		else
			return ResponseEntity.notFound().build();
	}
	
}









