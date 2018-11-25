package com.jm.tracker.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	private static final String ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";

	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()

				.authorizeRequests()

				// .antMatchers("/home", "/about", "/welcome",
				// "/userLogin").permitAll().antMatchers("/admin/**")
				.antMatchers("/home", "/about", "/welcome").permitAll().anyRequest().authenticated()

				.and().formLogin()

				.loginPage("/loginPage").loginProcessingUrl("/userLogin").defaultSuccessUrl("/home")
				.failureUrl("/error1").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);

	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("jm").password("123").roles("ADMIN");
	}

	// create two users, admin and user
	// @Override
	// public void configure(AuthenticationManagerBuilder auth) throws Exception {
	//
	// auth.inMemoryAuthentication().withUser("maki").password("pogi").roles("USER").and().withUser("admin")
	// .password("password").roles("ADMIN");
	// }

	/*
	 * Test Sept 29
	 */

	// FIlter

	// @Bean
	// public FilterRegistrationBean someFilterRegistration() {
	//
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(someFilter());
	// registration.addUrlPatterns("/url/*");
	// registration.addInitParameter("paramName", "paramValue");
	// registration.setName("someFilter");
	// registration.setOrder(1);
	// return registration;
	// }
	//
	// public Filter someFilter() {
	// return new SomeFilter();
	// }

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers("/css/**",
	// "/index").permitAll().antMatchers("/user/**").hasRole("USER")
	// .and().formLogin().loginPage("/login").failureUrl("/login-error");
	// }

}