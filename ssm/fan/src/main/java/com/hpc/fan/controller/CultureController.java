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
 * class：This is CultureController
 * 
 * @author hpc
 * @2017年3月21日下午5:25:18
 */
@Controller
@RequestMapping("/culture")
@SessionAttributes(value = { "nav", "titles" })
public class CultureController extends BaseController {

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
		mv.setViewName("company_culture");
		return mv;
	}

	/**
	 * 企业目标
	 */
	@RequestMapping("/qymb")
	public ModelAndView qygk(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.setViewName("company_culture");
		return mv;
	}

	/**
	 * 企业VI
	 */
	@RequestMapping("/qyvi")
	public ModelAndView qyvi(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.setViewName("company_culture");
		return mv;
	}

	/**
	 * 九州普惠学院
	 */
	@RequestMapping("/jzphxy")
	public ModelAndView jzphxy(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_culture");
		return mv;
	}

	/**
	 * 九州普惠报
	 */
	@RequestMapping("/jzphb")
	public ModelAndView jzphb(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_culture");
		return mv;
	}
}
