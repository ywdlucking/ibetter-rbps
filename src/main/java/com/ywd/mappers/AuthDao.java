package com.ywd.mappers;

import java.util.List;

import com.ywd.entity.Auth;

public interface AuthDao {
	
	public List<Auth> getAuthsByParentId(Integer parentId);

}
