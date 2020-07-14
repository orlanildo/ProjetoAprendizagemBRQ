package com.brq.EMotos.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.AuthUserDTO;
import com.brq.EMotos.models.User;
import com.brq.EMotos.services.LoginService;


@CrossOrigin(origins = "*")
@RequestMapping("/")
@RestController
public class loginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response, 
    		HttpServletRequest request) {
		
		AuthUserDTO userLoged = loginService.login(user, response, request);
		if(userLoged != null)
			//return ResponseEntity.ok().header("Autorization", userLoged.getToken()).body(userLoged);
			return ResponseEntity.ok().body(userLoged);
		else
			return ResponseEntity.notFound().build();
    }
	
	@GetMapping("logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
		
		loginService.logout(request);
		return ResponseEntity.ok().build();
	}

}
