package com.jm.tracker.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	// inject via application.properties
	// @Value("${error.message.403:test}")
	private String message = "ERROR 403";

	@GetMapping("/403")
	public String error403(Map<String, Object> model) {
		model.put("errorMessage", this.message);

		return "/error/403";
	}

	@GetMapping("/error1")
	// @Value("${error.message.default:test}")
	public String error(Map<String, Object> model) {
		model.put("errorMessage", this.message);
		// return "/login/login";
		return "/error/default";
	}

}
