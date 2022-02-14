package com.example.demo.UserWork;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userRegist {
	@RequestMapping("/user/regist")
	public String registUser() {
		return "user-regist";
	}
	@PostMapping("/user/regist")
	public String saveUser() {
		return "redirect:/login";
	}
}



