package com.ywd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ywd.entity.Auth;
import com.ywd.entity.Role;
import com.ywd.modle.TreeModel;
import com.ywd.service.AuthService;

@Controller
@RequestMapping("/main")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value="/getAuthTree", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAuthTree(@RequestParam("parentId")String parentId, HttpServletRequest request) throws Exception {	
		HttpSession session = request.getSession();
		Role role = (Role)session.getAttribute("role");
		List<TreeModel> authsByParentId = getAuthsByParentId(Integer.valueOf(parentId), role.getAuthIds());
		Gson gson = new Gson();
		String json = gson.toJson(authsByParentId);
		return json;
	}
	
	public List<TreeModel> getAuthsByParentId(Integer parentId, String authIds) {
		List<TreeModel> treeModels = new ArrayList<TreeModel>();
		List<Auth> authList = authService.getAuthsByParentId(parentId,authIds);
		for (Auth auth : authList) {
			TreeModel treeModel = new TreeModel();
			treeModel.setAuth(auth);
			if("open".equals(treeModel.getState())){
				treeModels.add(treeModel);
				continue;
			}else {
				treeModel.setChildren(getAuthsByParentId(treeModel.getId(),authIds));
			}
			treeModels.add(treeModel);
		}
		return treeModels;
	}
}
