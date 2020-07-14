package com.brq.EMotos.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


@Component
public class LoginFilter implements Filter {
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        
        if (httpRequest.getMethod().equals("OPTIONS") ||
        		httpRequest.getServletPath().startsWith("/login") ||
        		httpRequest.getServletPath().startsWith("/user/createUser")) {
        		//httpRequest.getServletPath().startsWith("/rent/showRent") ||
        		//httpRequest.getServletPath().startsWith("/moto/listMotos")) {
        		
            chain.doFilter(request, response);
            return;
        }
        
        /*
        Cookie token = WebUtils.getCookie(httpRequest, "token");
        if (token == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        */
        
        String token = httpRequest.getHeader("Authorization");
        
        if (token  == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        
        try {
            //String jwt = token.getValue();

            DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256("algoSecretoAqui"))
                    .build().verify(token);

            int idUserLoged = decodedJwt.getClaim("idUserLoged").asInt();
            httpRequest.setAttribute("idUserLoged", idUserLoged);
        	
            chain.doFilter(request, response);

        } catch (JWTVerificationException ex) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        		
	}
	
}

//        HttpSession session = httpRequest.getSession(false);
//        if (session == null || session.getAttribute("idUsuarioLogado") == null) {
//            // chamada sem autenticação
//            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
//            return;
//        }

/*
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
            try {
                chain.doFilter(req, res);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Pre-flight");
            response.setHeader("Access-Control-Allowed-Methods", "POST, GET, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type,x-auth-token, " +
                    "access-control-request-headers, access-control-request-method, accept, origin, authorization, x-requested-with");

            response.setStatus(HttpServletResponse.SC_OK);
        }

    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}
*/

