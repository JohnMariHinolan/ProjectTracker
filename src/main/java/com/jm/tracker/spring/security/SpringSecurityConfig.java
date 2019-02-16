package com.jm.tracker.spring.security;

//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private AccessDeniedHandler accessDeniedHandler;
//	private static final String ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";
//
//	// roles admin allow to access /admin/**
//	// roles user allow to access /user/**
//	// custom 403 access denied handler
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.csrf().disable()
//
//				.authorizeRequests()
//
//				.antMatchers("/*").permitAll().anyRequest().authenticated()
//				// .antMatchers("/home", "/about",
//				// "/welcome").permitAll().anyRequest().authenticated()
//				.and().formLogin()
//
//				.loginPage("/loginPage").loginProcessingUrl("/userLogin").defaultSuccessUrl("/home")
//				.failureUrl("/error1").permitAll().and().logout().permitAll().and().exceptionHandling()
//				.accessDeniedHandler(accessDeniedHandler);
//
//	}
//
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication().withUser("jm").password("123").roles("ADMIN");
//	}
//
//	
//
//}

public class SpringSecurityConfig {
}