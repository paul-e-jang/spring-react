package bashpound.marketplace.config.security;

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

import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.utils.WebUtil;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter implements Serializable {
	
	private static final long serialVersionUID = 3880669217418766370L;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	public AuthenticationFilter() {
		super(new AntPathRequestMatcher("/api/login","POST"));
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
			if(!WebUtil.isAjax(request) || !HttpMethod.POST.name().equals(request.getMethod())) {
				throw new AuthenticationServiceException("Authentication method not supported");
			}
			
			Member member = objectMapper.readValue(request.getReader(), Member.class);
			if(StringUtils.isEmpty(member.getUsername())) {
				throw new AuthenticationServiceException("Username is Empty");
				
			} else if (StringUtils.isEmpty(member.getPassword())) {
				throw new AuthenticationServiceException("Password is Empty");
			}
			AuthenticationToken authenticationToken = new AuthenticationToken(member.getUsername(),member.getPassword());
			
			
		return this.getAuthenticationManager().authenticate(authenticationToken);
	}
	
	@Override
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

}
