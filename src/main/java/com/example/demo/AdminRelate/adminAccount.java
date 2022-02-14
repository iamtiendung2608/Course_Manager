package com.example.demo.AdminRelate;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Role;

@Entity
public class adminAccount implements UserDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String username;
	private String password;
	private Role adminRole;
	
	public adminAccount(String username, String password, Role adminRole) {
		this.username = username;
		this.password = password;
		this.adminRole = adminRole;
	}
	public adminAccount() {
	}
	public adminAccount(int iD, String username, String password, Role adminRole) {
		ID = iD;
		this.username = username;
		this.password = password;
		this.adminRole = adminRole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority simple=new SimpleGrantedAuthority
				(adminRole.name());
		return Collections.singleton(simple);
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
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
	public Role getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(Role adminRole) {
		this.adminRole = adminRole;
	}
	public int getID() {
		return ID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
