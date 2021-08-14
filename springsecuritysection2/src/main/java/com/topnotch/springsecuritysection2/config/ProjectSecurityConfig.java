package com.topnotch.springsecuritysection2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

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

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource){
		return new JdbcUserDetailsManager(dataSource);
	}

}
