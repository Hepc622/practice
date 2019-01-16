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
 * class：This is NewsController
 * 
 * @author hpc
 * @2017年3月21日下午5:25:18
 */
@Controller
@RequestMapping("/news")
@SessionAttributes(value = { "nav", "titles" })
public class NewsController extends BaseController {
	@RequestMapping("")
	public ModelAndView news(@RequestParam("id") int id) {
		// 获取指定id的导航类
		Navigation nav = navigationService.getNavigationEntity(id);
		// 获取指定id导航类的子类
		List<Title> titles = titleService.getAllTitleEntity(nav.getNavigation_id());
		// 初始化 分页实体类
		Page page = new Page(contextService.getContextCount(titles.get(0).getTitle_id()));
		page.setEveryPage(4);
		page.getEndPage();
		// 获取第一个标题之内容
		List<Context> contexts = contextService.getAllContextEntity(titles.get(0).getTitle_id(),
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, 4);
		// 设置到request中
		mv.addObject("nav", nav);
		mv.addObject("titles", titles);
		mv.addObject("title", titles.get(0));
		// 获取之标题栏的第一个子内容
		mv.addObject("cons", contexts);
		mv.addObject("page", page);
		mv.setViewName("company_news");
		return mv;
	}

	@RequestMapping("/gsxw")
	public ModelAndView gsxw(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "page", required = false) Integer targetPage) {
		// 初始化 分页实体类
		Page page = new Page(contextService.getContextCount(id));
		// 目标页不等于空
		page.setCurrentPage(targetPage);
		page.setEveryPage(4);
		// 获取指定页数据
		List<Context> cons = contextService.getAllContextEntity(id,
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		mv.addObject("page", page);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.addObject("cons", cons);
		mv.setViewName("company_news");
		return mv;
	}

	@RequestMapping("/hydt")
	public ModelAndView hydt(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "page", required = false) Integer targetPage) {
		// 初始化 分页实体类
		Page page = new Page(contextService.getContextCount(id));
		// 目标页不等于空
		page.setCurrentPage(targetPage);
		page.setEveryPage(4);
		// 获取指定页数据
		List<Context> cons = contextService.getAllContextEntity(id,
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		mv.addObject("page", page);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.addObject("cons", cons);
		mv.setViewName("company_news");
		return mv;
	}

	@RequestMapping("/single")
	public ModelAndView single(@RequestParam(value = "id", required = true) Integer cid) {
		// 当前数据
		Context ccurrent = contextService.getContextEntity(false, cid);
		// 获取它的后一条数据
		Context cafter = contextService.getContextBeforeOrAfter(2, ccurrent.getParent_title().getTitle_id(), cid);
		// 获取它的前一条数据
		Context cbefore = contextService.getContextBeforeOrAfter(1, ccurrent.getParent_title().getTitle_id(), cid);
		mv.addObject("cafter", cafter);
		mv.addObject("ccurrent", ccurrent);
		mv.addObject("cbefore", cbefore);
		mv.setViewName("company_context");
		return mv;
	}
}
