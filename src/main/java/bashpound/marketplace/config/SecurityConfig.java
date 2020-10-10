package bashpound.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import bashpound.marketplace.config.security.AuthenticationDeniedHandler;
import bashpound.marketplace.config.security.AuthenticationEntryPointImpl;
import bashpound.marketplace.config.security.AuthenticationFilter;
import bashpound.marketplace.config.security.AuthenticationProviderImpl;
import bashpound.marketplace.config.security.SimpleAuthenticationFailureHanlder;
import bashpound.marketplace.config.security.SimpleAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	  private static final String[] PUBLIC = new String[]{
		  "/", "/error", "/login", "/api/logout", "/register", "/test", "/api/registrations", "/api/writeReply", "/api/default/articles",
		  "/api/MemberRegister"};
/*	  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("1111").roles("USER");
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(ajaxAuthenticationProvider());
	}
*/
		  
	    @Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		  
		@Bean
		public AuthenticationProviderImpl ajaxAuthenticationProvider() {
			return new AuthenticationProviderImpl();
		}
		
		@Bean
		public SimpleAuthenticationSuccessHandler SimpleAuthenticationSuccessHandler() {
			return new SimpleAuthenticationSuccessHandler();
		}
		@Bean
		public SimpleAuthenticationFailureHanlder SimpleAuthenticationFailureHanlder() {
			return new SimpleAuthenticationFailureHanlder();
		}
    
	  @Bean
	  public AuthenticationFilter ajaxAuthenticationFilter() throws Exception {
		  AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		  authenticationFilter.setAuthenticationManager(authenticationManagerBean());
		  authenticationFilter.setAuthenticationSuccessHandler(SimpleAuthenticationSuccessHandler());
		  authenticationFilter.setAuthenticationFailureHandler(SimpleAuthenticationFailureHanlder());
		  return authenticationFilter;
	  }
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
		  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	  }
	  
	  @Bean
	  public AuthenticationDeniedHandler ajaxAuthenticationDeniedHandler() {
		  return new AuthenticationDeniedHandler();
	  }

	 
	  @Override
	  public void configure(HttpSecurity http) throws Exception{
		  http	
	  			.formLogin()
  			.and()
  					.anonymous()
			.and()
		  		.authorizeRequests()
		  		.anyRequest().permitAll()
		  		//.antMatchers(PUBLIC).permitAll()
		  		//.anyRequest().authenticated()
	  		.and()
		  		.exceptionHandling()
	  			.authenticationEntryPoint(new AuthenticationEntryPointImpl())
	  			.accessDeniedHandler(ajaxAuthenticationDeniedHandler())
		  	.and()
		     	.addFilterBefore(ajaxAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		  http
	  			.csrf().disable();
	  }
	  
	  @Override
	  public void configure(WebSecurity web) {
	    web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "/images/**", "/favicon.ico");
	  }

}
