package com.sdelamer.midas.MidasChallenge.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.sdelamer.midas.MidasChallenge.Configuration.Jwt.JwtAuthenticationFilter;
import com.sdelamer.midas.MidasChallenge.Security.SecurityService.MyUserDetailsService;

@Configuration
@EnableWebSecurity(debug = false)
public class CustomWebSecurityConfigurationAdapter {

	@Autowired
	MyUserDetailsService userDetailsService;

	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;

	private final AuthenticationConfiguration configuration;

	public CustomWebSecurityConfigurationAdapter(AuthenticationConfiguration configuration) {
		this.configuration = configuration;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		auth.build();
	}

	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector);
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
//		http.csrf().disable();
//		http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());

		http.authorizeHttpRequests(authorize -> 		
		authorize.requestMatchers(mvc.pattern("/users")).hasRole("ADMIN")
				.requestMatchers(mvc.pattern(HttpMethod.PUT, "/products/**")).hasRole("ADMIN")
				.requestMatchers(mvc.pattern(HttpMethod.POST, "/products")).hasRole("ADMIN")
				.requestMatchers(mvc.pattern("/swagger-ui/**")).permitAll()
				.requestMatchers(mvc.pattern("/v3/**")).permitAll()
				.requestMatchers(mvc.pattern("/auth/login"))
				.permitAll().anyRequest().authenticated()	)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.csrf(AbstractHttpConfigurer::disable);

		return http.build();
	}

	@Bean
	AuthenticationManager authenticationManager() throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
