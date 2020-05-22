package com.brq.EMotos.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.User;

@RestController
@RequestMapping("/")
public class loginController {
	
	
	@PostMapping(value = "/login")
	public String login(@RequestBody User user, HttpSession session) {
		System.out.println("Chegou no login");
		
        //session.setAttribute("clientLoged", user);
        
        return "created session";
		
    }

	/*
	@RequestMapping(value = "/logar", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String logar(@ResponseBody User user, String email, String password, HttpSession session, HttpServletRequest request) {
		
		System.out.println(email);
		System.out.println(password);
		System.out.println(session);
		System.out.println(request);
		
		return "home";
	}
	*/

}
