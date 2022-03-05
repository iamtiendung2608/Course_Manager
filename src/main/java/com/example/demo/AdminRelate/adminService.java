package com.example.demo.AdminRelate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class adminService implements UserDetailsService {
	
	private repoAdminAccount repo;
	private BCryptPasswordEncoder encode;
	public adminService(repoAdminAccount repo, BCryptPasswordEncoder encode) {
		super();
		this.repo = repo;
		this.encode = encode;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repo.findByusername(username).orElseThrow(()
				-> new UsernameNotFoundException("Username not found"));
	}
	public String registAdmin(adminAccount account) {
		boolean isExist=repo.findByusername(account.getUsername()).isPresent();
		if(isExist)
			throw new IllegalStateException("Account already taken!");
		String newPassword=encode.encode(account.getPassword());
		if(newPassword==null)
			throw new IllegalStateException("Password mustn't be null");
		account.setPassword(newPassword);
		repo.save(account);
		return "redirect:/login";
	}
}
