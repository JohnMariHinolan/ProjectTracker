package com.jm.tracker.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

//public class NoPopupBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
public class NoPopupBasicAuthenticationEntryPoint {

	// public void commence(final HttpServletRequest request, final
	// HttpServletResponse response, final AuthenticationException authException)
	// throws IOException, ServletException {
	public void commence(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, ServletException {

		// response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
		// authException.getMessage());
	}

}