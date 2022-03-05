package com.example.demo.UserRelate;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface repoUserAccount extends CrudRepository<userAccount,Integer>{
	Optional<userAccount>findByusername(String username);
}
