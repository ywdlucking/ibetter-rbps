package com.ywd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywd.entity.Role;
import com.ywd.mappers.RoleDao;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role findByRoleId(Integer roleId) {
		return roleDao.findByRoleId(roleId);
	}

}
