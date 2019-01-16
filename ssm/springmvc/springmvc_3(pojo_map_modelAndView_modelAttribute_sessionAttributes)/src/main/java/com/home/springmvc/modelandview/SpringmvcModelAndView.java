package com.home.springmvc.modelandview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * �����ǣ�Springmvc ��ModelAndView
 * @author hpc
 * @2017��2��17������10:51:42
 */
@Controller
public class SpringmvcModelAndView {
	/**
	 * Ŀ�귽���ķ���ֵ������ ModelAndView ���͡� 
	 * ���п��԰�����ͼ��ģ����Ϣ
	 * SpringMVC ��� ModelAndView �� model �����ݷ��뵽 request �������. 
	 */
	@RequestMapping("/springmvcModelAndView")
	public ModelAndView springmvcModelAndView(){
		// ����ModelAndView����Я��model����ͼ
		ModelAndView mv = new ModelAndView();
		// ���ָ��Ҫ��ʾ����ͼ����
		mv.setViewName("success");
		// ���model(�Լ�ֵ�Եķ�ʽ)���Ὣ����뵽request����ȥ
		mv.addObject("name", "dyn");
		//����ModelAndView
		return mv;
	}
	
}

