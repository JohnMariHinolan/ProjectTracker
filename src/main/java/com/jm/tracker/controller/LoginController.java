package com.jm.tracker.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Separate service 
@Controller

public class LoginController {

	@Value("${login.welcome.message:test}")
	private String loginMessage = "login.welcome.message";

	@GetMapping("/loginPage")
	public String login(Map<String, Object> model) {

		model.put("loginMessage", this.loginMessage);
		return "/login/projectTracker";
		// return "/login/login";
	}

	@PostMapping("/userLogin")
	public void submit(@RequestParam("username") String userName, @RequestParam("password") String password) {

		System.out.println("Username = " + userName);
		System.out.println("password = " + password);

	}

}
