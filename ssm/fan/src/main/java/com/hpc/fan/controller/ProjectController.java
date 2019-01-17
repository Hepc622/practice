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
 * class��This is ProjectController
 * 
 * @author hpc
 * @2017��3��21������5:25:18
 */
@Controller
@RequestMapping("/project")
@SessionAttributes(value = { "nav", "titles" })
public class ProjectController extends BaseController {
	@RequestMapping("")
	public ModelAndView project(@RequestParam("id") int id,
			@RequestParam(value = "page", required = false) Integer targetPage) {
		// ��ȡָ��id�ĵ�����
		Navigation nav = navigationService.getNavigationEntity(id);
		// ��ȡָ��id�����������
		List<Title> titles = titleService.getAllTitleEntity(nav.getNavigation_id());
		// ��ʼ�� ��ҳʵ����
		Page page = new Page(contextService.getContextCount(id));
		page.setEveryPage(4);
		// ��ȡ��һ������֮����
		List<Context> contexts = contextService.getAllContextEntity(titles.get(0).getTitle_id(),
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		// ���õ�request��
		mv.addObject("nav", nav);
		mv.addObject("titles", titles);
		mv.addObject("title", titles.get(0));
		// ��ȡ֮�������ĵ�һ��������
		mv.addObject("cons", contexts);
		// ���÷�ҳ
		mv.addObject("page", page);
		mv.setViewName("company_project");
		return mv;
	}

	/**
	 * ���е�֮����
	 */
	@RequestMapping("/{title}")
	public ModelAndView title(@RequestParam(value = "id", required = true) int id,
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
		mv.setViewName("company_project");
		return mv;
	}

	@RequestMapping("/single")
	public ModelAndView single(@RequestParam(value = "id", required = true) Integer cid) {
		// ��ǰ����
		Context ccurrent = contextService.getContextEntity(false, cid);
		// ��ȡ���ĺ�һ������
		Context cafter = contextService.getContextBeforeOrAfter(2, ccurrent.getParent_title().getTitle_id(), cid);
		// ��ȡ����ǰһ������
		Context cbefore = contextService.getContextBeforeOrAfter(1, ccurrent.getParent_title().getTitle_id(), cid);
		mv.addObject("cafter", cafter);
		mv.addObject("ccurrent", ccurrent);
		mv.addObject("cbefore", cbefore);
		mv.setViewName("company_context");
		return mv;
	}

}