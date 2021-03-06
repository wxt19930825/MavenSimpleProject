package com.SpringBootProject.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.SpringBootProject.study.service.CustomUserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	UserDetailsService customUserService() {

		return new CustomUserService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(customUserService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/assets/**").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/loginSuccess")
				.failureUrl("/login?error").permitAll().and().logout()
				.permitAll();
	}
}
