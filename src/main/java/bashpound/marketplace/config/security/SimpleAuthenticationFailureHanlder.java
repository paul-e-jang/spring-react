package bashpound.marketplace.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import bashpound.marketplace.utils.Message;

public class SimpleAuthenticationFailureHanlder implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errorMessage = "Invalid Username or Password";
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		if(exception instanceof UsernameNotFoundException) {
			errorMessage = exception.getMessage();
		} else if(exception instanceof BadCredentialsException) {
			errorMessage = exception.getMessage();
		} else if(exception instanceof AuthenticationServiceException) {
			errorMessage = exception.getMessage();
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), new Message.Builder().message(errorMessage).build());
	}

}
