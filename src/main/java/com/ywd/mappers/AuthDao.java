package com.ywd.mappers;

import java.util.List;
import java.util.Map;

import com.ywd.entity.Auth;

public interface AuthDao {
	
	public List<Auth> getAuthsByParentId(Map<String ,Object> map);

}
