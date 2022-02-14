package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.AdminRelate.adminService;
@Configuration
@EnableWebSecurity

public class appSecurity extends WebSecurityConfigurerAdapter {
	private BCryptPasswordEncoder encode;
	private adminService service;
	

	public appSecurity(BCryptPasswordEncoder encode, adminService service) {
		super();
		this.encode = encode;
		this.service = service;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf()
					.disable()
			.authorizeHttpRequests()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/user/regist").permitAll()
			.antMatchers("/admin/regist").permitAll()
			.anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll();
		http.headers().frameOptions().disable();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception{
		auth
			.userDetailsService(service)
			.passwordEncoder(encode);
	}
}





