package com.sdelamer.midas.MidasChallenge.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdelamer.midas.MidasChallenge.Dto.UserDto;
import com.sdelamer.midas.MidasChallenge.Service.AppUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	AppUserService userService;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
	}

}
