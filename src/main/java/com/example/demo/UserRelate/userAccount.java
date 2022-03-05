package com.example.demo.UserRelate;



import com.example.demo.Degree;
import com.example.demo.Role;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
public class userAccount implements UserDetails {
	@Id
	private int Id;
	@NotBlank(message="username mustn't be null")
	private String username;
	
	
	@Pattern(regexp="[a-zA-Z]+",message="password must contain letter")
	private String password;
	private Role userRole;
	private Degree userDegree;
	public userAccount(String username, String password, Degree userDegree) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = Role.User;
		this.userDegree = userDegree;
	}
	public userAccount(int id, String username, String password) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.userRole=Role.User;
	}

	public userAccount() {
		this.userRole=Role.User;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(this.userRole.name());
		return Collections.singleton(authority);
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	public Degree getUserDegree() {
		return userDegree;
	}
	public void setUserDegree(Degree userDegree) {
		this.userDegree = userDegree;
	}
	public int getId() {
		return Id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}













