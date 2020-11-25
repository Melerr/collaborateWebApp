package pl.collaborateWebApp.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ScurityConfig extends WebSecurityConfigurerAdapter{
	
	private Logger logger = LoggerFactory.getLogger(ScurityConfig.class);
	
	
	@Autowired
	private UserDetailsService userDetailService;
	
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		logger.info("ScurityConfig: passwordEncoder " + passwordEncoder);
		
		return passwordEncoder;
		
	}*/
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	//Aythntication 
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("user").password("{noop}papa").roles("USER");
    	
    	auth.userDetailsService(userDetailService);
   
    	
    }
    
	
	// Autorizathion
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.info("ScurityConfig: configure HttpSecurity: START ");
		
		http.csrf().disable()
				.authorizeRequests()
				//.antMatchers(HttpMethod.GET, "/api/users/allRegister").permitAll()
				//.antMatchers(HttpMethod.GET, "/api/users/allRegister").hasAnyRole("USER_ROLE", "USER_ADMIN")
				.antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ROLE_USER", "ROLE_ADMIN")
				//.antMatchers(HttpMethod.POST, "/api/users**").permitAll()
				.anyRequest().authenticated()
			.and()
				.httpBasic();

				
		logger.info("ScurityConfig: configure HttpSecurity: END ");
		/*
		http.
			authorizeRequests()
			.antMatchers("/api/users/allRegister").permitAll()
			.antMatchers("/api/users/register").permitAll()
			.antMatchers("/api/appUser").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/appAdmin").hasAnyRole("ADMIN")
			.antMatchers("/api/home").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin()
		.and()
			.httpBasic();
		//	.logout().logoutUrl("/api/logmeout").logoutSuccessUrl("/api/home").permitAll();
        	//.logout().logoutUrl("/api/logmeout").logoutSuccessUrl("/api/home").permitAll();
        	 */
	}
	

}