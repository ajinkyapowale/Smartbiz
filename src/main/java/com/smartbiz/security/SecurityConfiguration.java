package com.smartbiz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.smartbiz.controller.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("ajinkya").password("ajinkya")
				.roles("ADMIN");
		//.roles("USER", "ADMIN","SALES_PERSON");
		 auth.userDetailsService(userDetailsService);
	     auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/login","/*theme*/**").permitAll()
		/*.antMatchers("/admin/**").access("hasAnyRole('ADMIN','ROLE_ADMIN')")
		.antMatchers("/sp/**").access("hasAnyRole('SALES_PERSON','ROLE_SALES_PERSON','ADMIN','ROLE_ADMIN')")*/
		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
		.antMatchers("/sp/**").hasAnyAuthority("SALES_PERSON","ADMIN")
		//.antMatchers("/", "/*todo*/**").access("hasAnyRole('USER','ADMIN','SALES_PERSON')")
		.anyRequest().authenticated()

		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.successHandler(myAuthenticationSuccessHandler())
		.failureUrl("/login?error=true")
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied")
		
		/*.and()
        .logout().deleteCookies("JSESSIONID")
         
        .and()
        .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400)// token validity seconds
*/		;
		
	}
	
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        //authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	 
	@Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new LoginSuccessHandler();
    }
}