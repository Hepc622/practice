package com.practice.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.chat.bean.ResultMsg;
import com.practice.chat.security.CurrentUser;
import com.practice.chat.security.OurUser;

@Controller
public class UserController {
	
	@RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg getUserInfo() {
		OurUser user = CurrentUser.getCurrentUser();
		user.setPassword("");
		return ResultMsg.success().setDatas("user", user);
	}
	
	@RequestMapping(value = "/main/admin",method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg admin() {
		OurUser user = CurrentUser.getCurrentUser();
		user.setPassword("");
		return ResultMsg.success().setDatas("user", user);
	}
}
