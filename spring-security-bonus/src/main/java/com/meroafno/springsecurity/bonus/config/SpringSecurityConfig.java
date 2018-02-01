package com.meroafno.springsecurity.bonus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add our users for in memory authentication
		
		UserBuilder users=User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("jana").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("presha").password("test123").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("pooja").password("test123").roles("EMPLOYEE","ADMIN"));
		
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/staff/allList*").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
			.antMatchers("/staff/search").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
			//.antMatchers("/staff/addStaff*").hasAnyRole("MANAGER","ADMIN")
			.antMatchers("/staff/delete*").hasRole("ADMIN")
			//.antMatchers("/staff/showFormForAdd*").hasAnyRole("MANAGER","ADMIN")
			.antMatchers("/staff/showFormForUpdate").hasAnyRole("ADMIN","MANAGER")
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
			
			
	}

	

	
}
