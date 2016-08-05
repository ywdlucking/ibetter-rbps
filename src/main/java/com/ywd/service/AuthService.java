package com.ywd.service;

import java.util.List;

import com.ywd.entity.Auth;

public interface AuthService {
	
	public List<Auth> getAuthsByParentId(Integer parentId, String authIds);
}
