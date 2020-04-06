package com.hgd.shop.service.impl;

import com.hgd.shop.mapper.UserMapper;
import com.hgd.shop.po.User;
import com.hgd.shop.service.UserService;
import com.hgd.shop.util.MapperUtils;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper=MapperUtils.getInstence().getDao(UserMapper.class);
	
	@Override
	public User login(User user) {
		return userMapper.login(user);
	}

}
