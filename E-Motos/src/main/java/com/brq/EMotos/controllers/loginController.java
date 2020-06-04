package com.brq.EMotos.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brq.EMotos.models.User;

@Controller
@RequestMapping("/")
public class loginController {
	
	// Crontrole temporario, utilizado para servir as jsp
	
	@CrossOrigin
	@RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        //System.out.println("Chegou no get login");
        return "login";
    }
	
	@CrossOrigin
    @RequestMapping(value = "sair", method = RequestMethod.GET)
    public void sair(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	@CrossOrigin
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(){
		return "register";
	}
	
	@CrossOrigin
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
    	
    	HttpSession session = request.getSession();
    	User testUserLoged = (User) session.getAttribute("clientLoged");
    	
		if(testUserLoged.getEmail() == null) {
			return "login";
		}
		
        return "home";
    }
    

}
