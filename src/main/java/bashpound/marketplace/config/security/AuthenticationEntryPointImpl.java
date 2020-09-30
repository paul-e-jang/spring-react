package bashpound.marketplace.config.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint{
	
	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		AuthenticationToken ajaxAuthenticationToken = (AuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = ajaxAuthenticationToken.getAuthorities();
		if(authorities != null) {			
			List<String> roles = new ArrayList<>();
			authorities.forEach( g -> roles.add(g.getAuthority()));
			
			objectMapper.writeValue(response.getWriter(), roles);
		} else {
			objectMapper.writeValue(response.getWriter(), "anonymous");
		}
	}

}
