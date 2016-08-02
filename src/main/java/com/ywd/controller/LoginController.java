package com.ywd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ywd.entity.User;
import com.ywd.service.UserService;
import com.ywd.util.StringUtil;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, Model model, HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();
		if(StringUtil.isEmpty(user.getUserName())||StringUtil.isEmpty(user.getPassword())){
			model.addAttribute("error", "用户名或密码为空！");
			return "login";
		}
		String imageCode = request.getParameter("imageCode");
		if(StringUtil.isEmpty(imageCode)){
			model.addAttribute("error", "验证码为空！！");
			return "login";
		}
		if(!imageCode.equals(session.getAttribute("sRand"))){
			model.addAttribute("error", "验证码错误！");
			return "login";
		}
		User findUser = userService.findUser(user);
		if(findUser == null){
			model.addAttribute("error", "用户名或密码错误！");
			return "login";
		}
		session.setAttribute("currentUser", findUser);
		return "main";
	}
}
