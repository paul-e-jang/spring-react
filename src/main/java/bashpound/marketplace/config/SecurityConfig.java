package bashpound.marketplace.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	  private static final String[] PUBLIC = new String[]{
		  "/", "/error", "/loginpage", "/api/logout", "/register", "/api/registrations", "/api/writeReply", "/api/default/articles"};

	 
	  @Override
	  public void configure(HttpSecurity http) throws Exception{
		  http
		      .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
		      .and()
		      .authorizeRequests()
		        .antMatchers(PUBLIC).permitAll()
		        .anyRequest().authenticated()
		      .and()
		      	.formLogin()
		      	.loginPage("/login")
		      	.addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		        .addFilterAfter(apiRequestExceptionTranslationFilter(), ExceptionTranslationFilter.class)
		        .permitAll()
		      .and()
		        .logout()
		        .logoutUrl("/api/logout")
		        .logoutSuccessHandler(logoutSuccessHandler())
		      .and()
		        .csrf().disable();
	  }

}
