package com.hpc.fan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * class：This is IndexController
 * 
 * @author hpc
 * @2017年3月12日下午4:12:53
 */
@Controller
@SessionAttributes("navs")
public class IndexController extends BaseController {
	/**
	 * 进入首页初始化数据
	 */
	@RequestMapping(value = { "/index", "/" })
	public ModelAndView init(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest hsr) {
		mv.setViewName("forward:/index.jsp");
		mv.addObject("navs", navigationService.getAllNavigationEntity());
		mv.addObject("pro", productService.getRandomProduct());
		return mv;
	}
}
