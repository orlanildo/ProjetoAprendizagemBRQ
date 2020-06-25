package com.brq.EMotos.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
	
	
    public AuthUserDTO login(User user, HttpServletResponse response){
    	
		if(user.getEmail() == null || user.getPassword() == null) {
			return null;
		}
		else if(user.getPassword().equals(ur.findByEmail(user.getEmail()).getPassword())){
			
			String jwt = JWT.create()
					.withClaim("idUserLoged", user.getId())
					.withClaim("emailUserLoged", user.getEmail())
					.withClaim("typeUserLoged", user.getType())
					.sign(Algorithm.HMAC256("algoSecretoAqui"));
			
			Cookie cookie = new Cookie("token", jwt);
			cookie.setPath("/");
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60 * 30); // 30 min
			
			response.addCookie(cookie);
			
			User userFinded = ur.findByEmail(user.getEmail());
			
			AuthUserDTO authUserDTO = new AuthUserDTO(userFinded.getId(), 
					userFinded.getEmail(), userFinded.getType(), cookie.getValue() );
			
            return authUserDTO;
	    }
    	
		return null;
	}
    
    public void logout(){
    	// remover o user do Cookie
    }

}
