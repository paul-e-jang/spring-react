package bashpound.marketplace.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	  private static final String[] PUBLIC = new String[]{
		  "/", "/error", "/loginpage", "/api/logout", "/register", "/api/registrations", "/api/writeReply", "/api/default/articles"};

	 
	  @Override
	  public void configure(HttpSecurity http) throws Exception{
		  http
		      .exceptionHandling()
		      .and()
		      .authorizeRequests()
		        .antMatchers(PUBLIC).permitAll()
		        .anyRequest().authenticated()
		      .and()
		      	.formLogin()
		      	.loginPage("/login")
		        .permitAll()
		      .and()
		        .logout()
		        .logoutUrl("/api/logout")
		      .and()
		        .csrf().disable();
	  }

}
