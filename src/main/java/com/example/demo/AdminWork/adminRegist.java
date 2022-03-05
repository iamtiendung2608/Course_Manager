package com.example.demo.AdminWork;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Degree;
import com.example.demo.AdminRelate.adminAccount;

import com.example.demo.AdminRelate.adminService;


@Controller
public class adminRegist {
	private adminService service;
	public adminRegist(adminService service) {
		super();
		this.service = service;
	}
	@RequestMapping("/admin/regist")
	public String registAdmin(@ModelAttribute("admin") adminAccount account,
			Model model) {
		model.addAttribute("degreeType", Degree.values());
		return "admin-regist";
	}
	@PostMapping("/admin/regist")
	public String saveAdmin(@ModelAttribute("admin") adminAccount account) {
		return service.registAdmin(account);
	}
}




