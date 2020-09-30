package bashpound.marketplace.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxAuthenticationDeniedHandler implements AccessDeniedHandler {
	
	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		String message = "Access is denied";
		
		response.setStatus(HttpStatus.FORBIDDEN.value());
		
		objectMapper.writeValue(response.getWriter(), message);
		
	}

}
