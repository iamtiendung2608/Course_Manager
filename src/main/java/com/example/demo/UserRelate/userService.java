package com.example.demo.UserRelate;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService implements UserDetailsService {
	private repoUserAccount repo;
	private BCryptPasswordEncoder encode;
	public userService(repoUserAccount repo, BCryptPasswordEncoder encode) {
		super();
		this.repo = repo;
		this.encode = encode;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return repo.findByusername(username).orElseThrow(
				()-> new UsernameNotFoundException("Username not found!"));
	}
	public String signupUser(userAccount user) {
		boolean isExist=repo.findByusername(user.getUsername()).isPresent();
		if(isExist)
			throw new IllegalStateException("Account already taken!");
		String newPassword=encode.encode(user.getPassword());
		user.setPassword(newPassword);
		repo.save(user);
		return "redirect:/login";
	}
	
}
