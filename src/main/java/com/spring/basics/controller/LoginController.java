package com.spring.basics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.basics.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World!";
	}
	
	@RequestMapping(path = {"/", "/login"}, method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if (!loginService.isUserValid(name, password)) {
			model.put("error", "Invalid Credentials!");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}

}
