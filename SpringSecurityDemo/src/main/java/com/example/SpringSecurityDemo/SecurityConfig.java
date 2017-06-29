package com.example.SpringSecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
				.withUser("dan")
				.password("password")
				.roles("ADMIN")
			.and()
				.withUser("joe")
				.password("password")
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/posts/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}


}
