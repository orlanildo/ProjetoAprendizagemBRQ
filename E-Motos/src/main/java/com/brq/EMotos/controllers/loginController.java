package com.brq.EMotos.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brq.EMotos.models.User;

@Controller
public class loginController {

	@RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}	
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody User client, HttpServletRequest request) {
		System.out.println(client.getEmail());
		System.out.println(client.getPassword());

		return "home";
    }
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
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
