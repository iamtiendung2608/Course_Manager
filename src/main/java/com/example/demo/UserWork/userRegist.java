package com.example.demo.UserWork;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Degree;
import com.example.demo.UserRelate.userAccount;
import com.example.demo.UserRelate.userService;

@Controller
public class userRegist {
	@Autowired
	private userService service;
	@RequestMapping("/user/regist")
	public String registUser(@ModelAttribute("user")userAccount user
			,Model model) {
		model.addAttribute("userType", Degree.values());
		return "user-regist";
	}
	@PostMapping("/user/regist")
	public String saveUser(@Valid@ModelAttribute("user")userAccount user
			,BindingResult Br,Model model) {
		if(Br.hasErrors()) {
			model.addAttribute("userType", Degree.values());
			return "user-regist";
		}
		return service.signupUser(user);
	}
}



