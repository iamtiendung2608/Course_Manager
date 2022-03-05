package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.AdminRelate.adminService;
import com.example.demo.UserRelate.userService;
@Configuration
@EnableWebSecurity

public class appSecurity extends WebSecurityConfigurerAdapter {
	private BCryptPasswordEncoder encode;
	private adminService service;
	private userService user;

	
	public appSecurity(BCryptPasswordEncoder encode, adminService service, userService user) {
		super();
		this.encode = encode;
		this.service = service;
		this.user = user;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf()
					.disable()
			.authorizeRequests()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/user/regist").permitAll()
			.antMatchers("/admin/regist").permitAll()
			.antMatchers("/user/regist").permitAll()
			.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
						.permitAll()
				.defaultSuccessUrl("/");
		http.headers().frameOptions().disable();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception{
		auth
			.userDetailsService(service)
			.and().userDetailsService(user)
			.passwordEncoder(encode);
	}
}





