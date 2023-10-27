package com.sdelamer.midas.MidasChallenge.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdelamer.midas.MidasChallenge.Dto.ProductDto;
import com.sdelamer.midas.MidasChallenge.Dto.UserDto;
import com.sdelamer.midas.MidasChallenge.Service.AppUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	AppUserService userService;

	@Operation(summary = "Gets all app users")
	@GetMapping
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found Users", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class)) }) })
	public ResponseEntity<List<UserDto>> findAllUsers() {
		return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
	}

}
