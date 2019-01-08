package com.spring.basics.jee;

public class UserValidationService {
	
	public boolean isUserValid(String user, String password) {
		if (user.equals("test") && password.equals("12345")) {
			return true;
		}
		return false;
	}
	
}
