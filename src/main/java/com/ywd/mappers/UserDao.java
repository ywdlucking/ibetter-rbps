package com.ywd.mappers;

import com.ywd.entity.User;

public interface UserDao {
	
	public User getUserByName(String userName);
	
	public User findUser(User user);
}
