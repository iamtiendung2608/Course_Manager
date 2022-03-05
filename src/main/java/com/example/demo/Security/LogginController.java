package com.example.demo.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogginController {
	@RequestMapping("/login")
	public String loggin() {
		return "login";
	}
	@RequestMapping("/")
	public String Intro() {
		return "intro";
	}
}
