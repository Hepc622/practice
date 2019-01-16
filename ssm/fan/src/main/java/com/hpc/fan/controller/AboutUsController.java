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
 * class��This is AboutUsController
 * 
 * @author hpc
 * @2017��3��21������5:25:18
 */
@Controller
@RequestMapping("/about")
@SessionAttributes(value = { "nav", "titles" })
public class AboutUsController extends BaseController {
	@RequestMapping("")
	public ModelAndView about(@RequestParam("id") int id) {
		// ��ȡָ��id�ĵ�����
		Navigation nav = navigationService.getNavigationEntity(id);
		// ��ȡָ��id�����������
		List<Title> titles = titleService.getAllTitleEntity(nav.getNavigation_id());
		// ��ȡ��һ������֮����
		Context context = contextService.getContextEntity(true, titles.get(0).getTitle_id());
		// ���õ�request��
		mv.addObject("nav", nav);
		mv.addObject("titles", titles);
		mv.addObject("title", titles.get(0));
		// ��ȡ֮�������ĵ�һ��������
		mv.addObject("con", context);
		mv.setViewName("company_about");
		return mv;
	}

	/**
	 * ��ҵ����
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
	 * �����з�
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
	 * ��������
	 */
	@RequestMapping("/ryzz")
	public ModelAndView ryzz(@RequestParam(value = "id", required = true) int id,
							 @RequestParam(value = "page", required = false) Integer targetPage) {
		// ��ʼ�� ��ҳʵ����
		Page page = new Page(contextService.getContextCount(id));
		page.setEveryPage(9);
		// Ŀ��ҳ�����ڿ�
		page.setCurrentPage(targetPage);
		// ��ȡָ��ҳ����
		List<Context> cons = contextService.getAllContextEntity(id,
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		mv.addObject("page", page);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.addObject("cons", cons);
		mv.setViewName("company_about");
		return mv;
	}

	/**
	 * ��չ����
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
	 * ��������
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
	 * ����Զ��
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
