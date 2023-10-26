package com.sdelamer.midas.MidasChallenge.Security.SecurityService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.sdelamer.midas.MidasChallenge.Model.AppUser;
import com.sdelamer.midas.MidasChallenge.Repository.AppUserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	AppUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		AppUser appUser = userRepository.findByEmail(username);
		if (appUser != null) {
			return createAuthorizedUserFromAppUser(appUser);
		}
		return null;
	}

	private UserDetails createAuthorizedUserFromAppUser(AppUser appUser) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUser.getRole() == null ? "USER" : appUser.getRole().getName());
		return new User(appUser.getEmail(), appUser.getPassword(), List.of(grantedAuthority));
	}

}
