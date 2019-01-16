package com.hpc.fan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hpc.fan.bean.Context;
import com.hpc.fan.bean.Navigation;
import com.hpc.fan.bean.Page;
import com.hpc.fan.bean.Title;

/**
 * class：This is AboutUsController
 * 
 * @author hpc
 * @2017年3月21日下午5:25:18
 */
@Controller
@RequestMapping("/about")
@SessionAttributes(value = { "nav", "titles" })
public class AboutUsController extends BaseController {
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
		mv.setViewName("company_about");
		return mv;
	}

	/**
	 * 企业概括
	 */
	@RequestMapping("/qygk")
	public ModelAndView qygk(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_about");
		return mv;
	}

	/**
	 * 技术研发
	 */
	@RequestMapping("/jsyf")
	public ModelAndView jzyf(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_about");
		return mv;
	}
	/**
	 * 荣誉资质
	 */
	@RequestMapping("/ryzz")
	public ModelAndView ryzz(@RequestParam(value = "id", required = true) int id,
							 @RequestParam(value = "page", required = false) Integer targetPage) {
		// 初始化 分页实体类
		Page page = new Page(contextService.getContextCount(id));
		page.setEveryPage(9);
		// 目标页不等于空
		page.setCurrentPage(targetPage);
		// 获取指定页数据
		List<Context> cons = contextService.getAllContextEntity(id,
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		mv.addObject("page", page);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.addObject("cons", cons);
		mv.setViewName("company_about");
		return mv;
	}

	/**
	 * 发展历程
	 */
	@RequestMapping("/fzlc")
	public ModelAndView fzlc(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_about");
		return mv;
	}

	/**
	 * 生产管理
	 */
	@RequestMapping("/scgl")
	public ModelAndView scgl(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_about");
		return mv;
	}

	/**
	 * 九州远景
	 */
	@RequestMapping("/jzyj")
	public ModelAndView jzyj(@RequestParam("id") int id) {
		Context context = contextService.getContextEntity(true, id);
		mv.addObject("con", context);
		mv.addObject("title", context.getParent_title());
		mv.setViewName("company_about");
		return mv;
	}
}
