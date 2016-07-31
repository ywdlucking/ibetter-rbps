package com.ywd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ywd.entity.Auth;
import com.ywd.service.AuthService;

@Controller
@RequestMapping("/")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value="/getAuthTree", method=RequestMethod.GET)
	public String getAuthTree(@RequestParam("parentId")String parentId){	
		List<Auth> authList = authService.getAuthsByParentId(parentId);
		for (Auth auth : authList) {
			
		}
		return null;
	}
}
