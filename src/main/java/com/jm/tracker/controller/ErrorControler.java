package com.jm.tracker.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class ErrorControler {

	// inject via application.properties
		@Value("${error.message.403:test}")
		private String message = "ERROR 403";
	
		@GetMapping("/403")
	    public String error403(Map<String, Object> model) {
			model.put("errorMessage", this.message);
		
	        return "/error/403";
	    }
	
	
}
