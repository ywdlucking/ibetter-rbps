package com.ywd.service;

import com.ywd.entity.User;

public interface UserService {
	
	public User getUserByName(String userName);
	
	public User findUser(User user);
}
