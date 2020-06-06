package com.mgl.chr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
			.and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.and()
			.authorizeRequests()
				.antMatchers("/chr/hospital/records", "/chr/hospital/subscribe", "/chr/hospital/registration")
				.permitAll()
			.and()
			.authorizeRequests().antMatchers("/h2-console/**").permitAll()
			.and()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.httpBasic();
	}
}
