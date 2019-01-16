package com.hpc.fan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hpc.fan.bean.Context;
import com.hpc.fan.bean.Navigation;
import com.hpc.fan.bean.Title;

/**
 * class：This is ServiceController
 * 
 * @author hpc
 * @2017年3月21日下午5:25:18
 */
@Controller
@RequestMapping("/service")
@SessionAttributes(value = { "nav", "titles" })
public class ServiceController extends BaseController {
	@RequestMapping("")
	public ModelAndView about(@RequestParam("id") int id) {
		// 获取指定id的导航类
		Navigation nav = navigationService.getNavigationEntity(id);
		// 获取指定id导航类的子类
		List<Title> titles = titleService.getAllTitleEntity(nav.getNavigation_id());
		// 获取第一个标题之内容
		Context context = contextService.getContextEntity(true, titles.get(0).getTitle_id());
		// 设置到request中
		mv.addObject("nav", nav);
		mv.addObject("titles", titles);
		mv.addObject("title", titles.get(0));
		// 获取之标题栏的第一个子内容
		mv.addObject("con", context);
		mv.setViewName("company_service");
		return mv;
	}

	/**
	 * 招商服务
	 */
	@RequestMapping("/zszp")
	public ModelAndView zszp(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_service");
		return mv;
	}

	/**
	 * 服务理念
	 */
	@RequestMapping("/fwll")
	public ModelAndView fwll(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.setViewName("company_service");
		return mv;
	}

	/**
	 * 售后服务
	 */
	@RequestMapping("/shfw")
	public ModelAndView shfw(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_service");
		return mv;
	}

}
