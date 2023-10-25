package com.sdelamer.midas.MidasChallenge.Security.SecurityService;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sdelamer.midas.MidasChallenge.Configuration.Jwt.JwtService;
import com.sdelamer.midas.MidasChallenge.Model.AppUser;
import com.sdelamer.midas.MidasChallenge.Model.Security.AuthenticationResponse;
import com.sdelamer.midas.MidasChallenge.Model.Security.LoginRequest;
import com.sdelamer.midas.MidasChallenge.Repository.AppUserRepository;

@Service
public class AuthenticationService {
	@Autowired
	AppUserRepository userRepository;
	@Autowired
	JwtService jwtService;
	@Autowired
	AuthenticationManager authenticationManager;

	public AuthenticationResponse loginUser(LoginRequest loginRequest) throws LoginException {
		
		AppUser user = userRepository.findByEmail(loginRequest.getUsername());
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		if (user == null) {
			throw new LoginException("Usuario no encontrado");
		}
		String token = jwtService.generateToken((UserDetails) authenticate.getPrincipal());
		return new AuthenticationResponse(token);

	}

}
