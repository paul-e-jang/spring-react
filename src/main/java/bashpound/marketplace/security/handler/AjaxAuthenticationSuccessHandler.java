package bashpound.marketplace.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import bashpound.marketplace.domain.model.entity.Member;

public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	ObjectMapper objectMapper = new ObjectMapper();
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Member member = (Member)authentication.getPrincipal();
		
		response.setStatus(HttpStatus.OK.value());
		
		RequestCache requestCache = new HttpSessionRequestCache();
		
		SavedRequest savedRequest =requestCache.getRequest(request, response);
		if(savedRequest == null) {
			objectMapper.writeValue(response.getWriter(), member);
		} else {
			String requestUrl = savedRequest.getRedirectUrl();
			objectMapper.writeValue(response.getWriter(), requestUrl);
		}
	}

}
