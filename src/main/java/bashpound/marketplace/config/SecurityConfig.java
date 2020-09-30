package bashpound.marketplace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import bashpound.marketplace.security.filter.AjaxAuthenticationFilter;
import bashpound.marketplace.security.handler.AjaxAuthenticationDeniedHandler;
import bashpound.marketplace.security.handler.AjaxAuthenticationFailureHanlder;
import bashpound.marketplace.security.handler.AjaxAuthenticationSuccessHandler;
import bashpound.marketplace.security.provider.AjaxAuthenticationProvider;
import bashpound.marketplace.security.util.AjaxAuthenticationEntryPoint;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	  private static final String[] PUBLIC = new String[]{
		  "/", "/error", "/loginpage", "/api/logout", "/register", "/api/registrations", "/api/writeReply", "/api/default/articles"};
	  
	  @Autowired
	  private UserDetailsService userDetailsService;
	  
	  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("1111").roles("USER");
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(ajaxAuthenticationProvider());
	}
	  
    @Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	  
    	@Bean
    	public AjaxAuthenticationProvider ajaxAuthenticationProvider() {
    		return new AjaxAuthenticationProvider();
    	}
    	
    	@Bean
    	public AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler() {
    		return new AjaxAuthenticationSuccessHandler();
    	}
    	@Bean
    	public AjaxAuthenticationFailureHanlder ajaxAuthenticationFailureHandler() {
    		return new AjaxAuthenticationFailureHanlder();
    	}
    
	  @Bean
	  public AjaxAuthenticationFilter ajaxAuthenticationFilter() throws Exception {
		  AjaxAuthenticationFilter ajaxAuthenticationFilter = new AjaxAuthenticationFilter();
		  ajaxAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
		  ajaxAuthenticationFilter.setAuthenticationSuccessHandler(ajaxAuthenticationSuccessHandler());
		  ajaxAuthenticationFilter.setAuthenticationFailureHandler(ajaxAuthenticationFailureHandler());
		  return ajaxAuthenticationFilter;
	  }
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
		  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	  }
	  
	  @Bean
	  public AjaxAuthenticationDeniedHandler ajaxAuthenticationDeniedHandler() {
		  return new AjaxAuthenticationDeniedHandler();
	  }

	 
	  @Override
	  public void configure(HttpSecurity http) throws Exception{
		  http	
	  			.formLogin()
  			.and()
  					.anonymous()
			.and()
		  		.authorizeRequests()
		  		.antMatchers(PUBLIC).permitAll()
		  		.anyRequest().authenticated()
	  		.and()
		  		.exceptionHandling()
	  			.authenticationEntryPoint(new AjaxAuthenticationEntryPoint())
	  			.accessDeniedHandler(ajaxAuthenticationDeniedHandler())
		  	.and()
		     	.addFilterBefore(ajaxAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		  http
	  			.csrf().disable();
	  }

}
