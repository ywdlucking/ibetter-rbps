package com.ywd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ywd.entity.Auth;
import com.ywd.modle.TreeModel;
import com.ywd.service.AuthService;

@Controller
@RequestMapping("/main")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value="/getAuthTree", method=RequestMethod.GET)
	@ResponseBody
	public String getAuthTree(@RequestParam("parentId")String parentId) throws Exception {	
		List<TreeModel> authsByParentId = getAuthsByParentId(parentId);
		Gson gson = new Gson();
		String json = gson.toJson(authsByParentId);
		System.out.println(json);
		return json;
	}
	
	public List<TreeModel> getAuthsByParentId(String parentId) {
		List<TreeModel> treeModels = new ArrayList<TreeModel>();
		List<Auth> authList = authService.getAuthsByParentId(parentId);
		for (Auth auth : authList) {
			TreeModel treeModel = new TreeModel();
			treeModel.setAuth(auth);
			if("open".equals(treeModel.getState())){
				continue;
			}else {
				treeModel.setChildren(getAuthsByParentId(String.valueOf(treeModel.getId())));
			}
		}
		return treeModels;
	}
}
