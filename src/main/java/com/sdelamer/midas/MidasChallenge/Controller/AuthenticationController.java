package com.sdelamer.midas.MidasChallenge.Controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdelamer.midas.MidasChallenge.Model.Security.AuthenticationResponse;
import com.sdelamer.midas.MidasChallenge.Model.Security.LoginRequest;
import com.sdelamer.midas.MidasChallenge.Security.SecurityService.AuthenticationService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;
	

	@GetMapping("/login")
	public ResponseEntity<String> testGet() throws LoginException {
		return ResponseEntity.ok("Loged in!");
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) throws LoginException {
		return ResponseEntity.ok(authenticationService.loginUser(loginRequest));
	}
	
}
