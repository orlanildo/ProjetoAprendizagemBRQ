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
	
	@CrossOrigin
	@RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        //System.out.println("Chegou no get login");
        return "login";
    }
	
	@CrossOrigin
    @RequestMapping(value = "sair", method = RequestMethod.GET)
    public String sair(HttpServletRequest request){
		System.out.println("Saindo...");
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
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
    
//	@PostMapping(value = "/login")
//	public String login(@RequestBody User user, HttpSession session) {
//		System.out.println("Chegou no login");
//		
//        //session.setAttribute("clientLoged", user);
//        
//        return "created session";
//		
//    }

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
