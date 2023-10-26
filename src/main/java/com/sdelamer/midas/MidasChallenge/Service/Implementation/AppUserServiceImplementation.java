package com.sdelamer.midas.MidasChallenge.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdelamer.midas.MidasChallenge.Dto.UserDto;
import com.sdelamer.midas.MidasChallenge.Mapper.AppUserMapper;
import com.sdelamer.midas.MidasChallenge.Model.AppUser;
import com.sdelamer.midas.MidasChallenge.Repository.AppUserRepository;
import com.sdelamer.midas.MidasChallenge.Service.AppUserService;

@Service
public class AppUserServiceImplementation implements AppUserService{

	@Autowired
	AppUserRepository userRepository;
	@Autowired
	AppUserMapper userMapper;
	
	@Override
	public List<UserDto> findAllUsers() {
		
		List<AppUser> appUserList = userRepository.findAll();
		List<UserDto> usersToUserDto = userMapper.usersToUserDto(appUserList);
		return usersToUserDto;
	}

}
