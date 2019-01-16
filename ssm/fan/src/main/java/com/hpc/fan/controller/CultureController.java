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
 * class��This is CultureController
 * 
 * @author hpc
 * @2017��3��21������5:25:18
 */
@Controller
@RequestMapping("/culture")
@SessionAttributes(value = { "nav", "titles" })
public class CultureController extends BaseController {

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
		mv.setViewName("company_culture");
		return mv;
	}

	/**
	 * ��ҵĿ��
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
	 * ��ҵVI
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
	 * �����ջ�ѧԺ
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
	 * �����ջݱ�
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
