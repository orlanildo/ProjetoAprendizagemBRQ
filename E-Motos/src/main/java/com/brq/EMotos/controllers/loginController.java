package com.brq.EMotos.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brq.EMotos.models.User;

@RestController
public class loginController {
	
	
	@PostMapping(value = "/createMoto", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody User client, HttpServletRequest request, HttpSession session) {
		System.out.println("Chegou no login");
		
        session.setAttribute("clientLoged", client);
        
        return "retur created session";
		
    }
	
	/*
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "createClient", method = RequestMethod.POST)
	public String criateClient (@RequestBody Client client, HttpSession session){
		
		System.out.println("Entrou no criateClient: ");
		System.out.println(client.getName());
		System.out.println(client.getEmail());
		System.out.println(client.getPassword());
		
		if (client != null) {
			session.setAttribute("clientLoged", client);
		}
		
		cr.save(client);
		
		return "home";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
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
