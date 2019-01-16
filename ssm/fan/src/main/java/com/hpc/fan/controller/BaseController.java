package com.hpc.fan.controller;

import javax.annotation.Resource;

import org.springframework.web.servlet.ModelAndView;

import com.hpc.fan.service.ContextService;
import com.hpc.fan.service.NavigationService;
import com.hpc.fan.service.ProductService;
import com.hpc.fan.service.TitleService;
import com.hpc.fan.service.UserService;

/**
 * class：This is BaseController
 * 
 * @author hpc
 * @2017年3月23日下午8:15:22
 */
public abstract class BaseController {
	@Resource
	public ProductService productService;
	@Resource
	public NavigationService navigationService;
	@Resource
	public TitleService titleService;
	@Resource
	public ContextService contextService;
	@Resource
	public UserService userService;
	public ModelAndView mv;

	public BaseController() {
		this.mv = new ModelAndView();
	}
}
