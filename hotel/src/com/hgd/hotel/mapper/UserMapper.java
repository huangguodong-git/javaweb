package com.hgd.hotel.mapper;

import com.hgd.hotel.dto.UserDto;
import com.hgd.hotel.po.User;

public interface UserMapper {

	User login(UserDto userDto);

	void register(User user);

	User findByLoginName(String loginname);

}
