package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


@Component
@Order(0)
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
    		FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;

        if (!httpRequest.getServletPath().startsWith("/")) {
            // requisição para recurso estático
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getServletPath().startsWith("/login")) {
            // o usuário está tentando se autenticar
            chain.doFilter(request, response);
            return;
        }

//        HttpSession session = httpRequest.getSession(false);
//        if (session == null || session.getAttribute("idUsuarioLogado") == null) {
//            // chamada sem autenticação
//            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
//            return;
//        }

        Cookie token = WebUtils.getCookie(httpRequest, "token");
        if (token == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        try {
        	
            String jwt = token.getValue();

            DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256("algoSecretoAqui"))
                    .build().verify(jwt);

            Integer idUserLoged = decodedJwt.getClaim("idUserLoged").asInt();
            httpRequest.setAttribute("idUserLoged", idUserLoged);

            // chamada autenticada
            chain.doFilter(request, response);

        } catch (JWTVerificationException ex) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

}

