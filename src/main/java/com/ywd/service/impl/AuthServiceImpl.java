package com.ywd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywd.entity.Auth;
import com.ywd.mappers.AuthDao;
import com.ywd.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private AuthDao authDao;

	@Override
	public List<Auth> getAuthsByParentId(String parentId) {
		return authDao.getAuthsByParentId(parentId);
	}

}
