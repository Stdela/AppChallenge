package com.sdelamer.midas.MidasChallenge.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdelamer.midas.MidasChallenge.Dto.UserDto;
import com.sdelamer.midas.MidasChallenge.Model.AppUser;

@Component
public class AppUserMapper {

	@Autowired
	ModelMapper modelMapper;

	public List<UserDto> usersToUserDto(List<AppUser> appUsers) {
		List<UserDto> userDto = new ArrayList<>();
		for (AppUser appUser : appUsers) {
			UserDto map = modelMapper.map(appUser, UserDto.class);
			userDto.add(map);
		}
		return 	userDto;
//		return appUsers.stream().map(x -> modelMapper.map(x, UserDto.class)).collect(Collectors.toList());

	}

}
