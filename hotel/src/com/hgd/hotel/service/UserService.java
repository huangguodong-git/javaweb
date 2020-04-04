package com.hgd.hotel.service;

import com.hgd.hotel.dto.UserDto;
import com.hgd.hotel.po.User;

public interface UserService {

	User login(UserDto userDto);

	void register(User user);

	User findByLoginName(String loginname);

}
