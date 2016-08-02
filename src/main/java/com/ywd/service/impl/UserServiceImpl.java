package com.ywd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywd.entity.User;
import com.ywd.mappers.UserDao;
import com.ywd.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	@Override
	public User findUser(User user) {
		return userDao.findUser(user);
	}

}
