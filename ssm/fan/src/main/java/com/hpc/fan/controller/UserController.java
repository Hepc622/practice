package com.hpc.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hpc.fan.bean.User;

/**
 * class：This is ServiceController
 * 
 * @author hpc
 * @2017年3月21日下午5:25:18
 */
@Controller
@SessionAttributes("user")
public class UserController extends BaseController {
	@RequestMapping("/loginUser")
	public ModelAndView login(User user) {
		User u = userService.getUserEntity(user.getUser_name());
		if (u.getUser_name().equals(user.getUser_name()) && u.getUser_pwd().equals(user.getUser_pwd())) {
			mv.addObject("user", u);
			mv.setViewName("forward:/index.jsp");
			return mv;
		} else {
			mv.setViewName("forward:/login.jsp");
			return mv;
		}
	}
	/*
	 * @RequestMapping("/updateUser") public @ResponseBody int update(User user)
	 * { try { userService.updateUserEntity(user); return 1; } catch (Exception
	 * e) { System.out.println(e); return 0; } }
	 */

}
