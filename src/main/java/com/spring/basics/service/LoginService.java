package com.spring.basics.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if (user.equals("test") && password.equals("12345")) {
			return true;
		}
		return false;
	}
	
}
