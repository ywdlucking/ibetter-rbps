package com.ywd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Auth> getAuthsByParentId(Integer parentId, String authIds) {
		Map<String ,Object> map = new HashMap<String ,Object>();
		map.put("parentId", parentId);
		map.put("authIds", authIds.split(","));
		return authDao.getAuthsByParentId(map);
	}

}
