package com.brq.EMotos.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.brq.EMotos.models.AuthUserDTO;
import com.brq.EMotos.models.User;
import com.brq.EMotos.repository.UserRepository;


@Service
public class LoginService {
	
	@Autowired
	private UserRepository ur;
	
	
    public AuthUserDTO login(User user, HttpServletResponse response, 
    		HttpServletRequest request){
    	
		if(user.getEmail() != null || user.getPassword() != null) {

			User userFinded = ur.findByEmail(user.getEmail());
			if(userFinded != null && user.getPassword().equals(userFinded.getPassword())) {
				
				String jwt = JWT.create()
					.withClaim("idUserLoged", userFinded.getId())
					.withClaim("emailUserLoged", userFinded.getEmail())
					.withClaim("typeUserLoged", userFinded.getType())
					.sign(Algorithm.HMAC256("algoSecretoAqui"));
	
				/*
				Cookie cookie = new Cookie("token", jwt);
				cookie.setPath("*");
				cookie.setSecure(false);
				cookie.setHttpOnly(false);
				cookie.setMaxAge(60 * 30); // 30 min
				response.addCookie(cookie);
				*/
				
				response.setHeader("Authorization", jwt);
				
				//HttpSession session = request.getSession();
				//session.setAttribute ("token", jwt);
				
				AuthUserDTO authUserDTO = new AuthUserDTO(userFinded.getId(), 
						userFinded.getEmail(), userFinded.getType(), jwt);
				
	            return authUserDTO;
		    }
		}
		return null;
	}
    
    public void logout(HttpServletRequest request){

    	/*
		Cookie cookie = new Cookie("token", null);
		cookie.setMaxAge(0); // 0Cookie expired
		response.addCookie(cookie);
		*/
    	
    	HttpSession session = request.getSession();
    	
    	session.invalidate();
    }

}
