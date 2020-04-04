package com.hgd.hotel.service.impl;

import com.hgd.hotel.dto.UserDto;
import com.hgd.hotel.mapper.UserMapper;
import com.hgd.hotel.po.User;
import com.hgd.hotel.service.UserService;
import com.hgd.hotel.util.MapperUtils;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper=MapperUtils.getInstence().getDao(UserMapper.class);
	
	@Override
	public User login(UserDto userDto) {
		return userMapper.login(userDto);
	}

	@Override
	public void register(User user) {
		userMapper.register(user);
	}

	@Override
	public User findByLoginName(String loginname) {
		return userMapper.findByLoginName(loginname);
	}

}
