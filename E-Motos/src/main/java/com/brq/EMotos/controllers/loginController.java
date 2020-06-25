package com.brq.EMotos.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.User;
import com.brq.EMotos.services.LoginService;


@CrossOrigin(origins = "*")
@RequestMapping("/")
@RestController
public class loginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response) {

		return ResponseEntity.ok(loginService.login(user, response));
    }
	
	@GetMapping("logout")
    public ResponseEntity<?> logout(){
		
		loginService.logout();
		return ResponseEntity.ok().build();
	}

}
