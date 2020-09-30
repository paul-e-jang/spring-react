package bashpound.marketplace.security.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import bashpound.marketplace.domain.model.MemberDTO;
import bashpound.marketplace.security.token.AjaxAuthenticationToken;
import bashpound.marketplace.security.util.WebUtil;

public class AjaxAuthenticationFilter extends AbstractAuthenticationProcessingFilter implements Serializable {
	
	private static final long serialVersionUID = 3880669217418766370L;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	public AjaxAuthenticationFilter() {
		super(new AntPathRequestMatcher("/api/login","POST"));
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
			if(!WebUtil.isAjax(request) || !HttpMethod.POST.name().equals(request.getMethod())) {
				throw new AuthenticationServiceException("Authentication method not supported");
			}
			
			MemberDTO memberDTO = objectMapper.readValue(request.getReader(), MemberDTO.class);
			if(StringUtils.isEmpty(memberDTO.getUsername())) {
				throw new AuthenticationServiceException("Username is Empty");
				
			} else if (StringUtils.isEmpty(memberDTO.getPassword())) {
				throw new AuthenticationServiceException("Password is Empty");
			}
			AjaxAuthenticationToken ajaxAuthenticationToken = new AjaxAuthenticationToken(memberDTO.getUsername(),memberDTO.getPassword());
			
			
		return this.getAuthenticationManager().authenticate(ajaxAuthenticationToken);
	}
	
	@Override
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

}
