package com.topnotch.springsecuritysection2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		  http .authorizeRequests()
		  .antMatchers("/myAccount").authenticated()
		  .antMatchers("/myBalance").authenticated()
		  .antMatchers("/myLoans").authenticated()
		  .antMatchers("/myCards").authenticated()
		  .antMatchers("/contact","/notices").permitAll()
				  .and()
		  .formLogin()
				  .and()
		  .httpBasic();
			
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
			.withUser("admin").password("1234").authorities("admin")
		.and()
			.withUser("user").password("1234").authorities("read")
		.and()
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

}
