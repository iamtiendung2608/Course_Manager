package com.example.demo.AdminRelate;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface repoAdminAccount extends CrudRepository<adminAccount,Integer> {
	Optional<adminAccount> findByusername(String username);
}
