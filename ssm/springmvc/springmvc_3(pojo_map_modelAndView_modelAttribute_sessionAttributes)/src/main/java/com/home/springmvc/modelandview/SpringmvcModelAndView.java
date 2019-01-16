package com.home.springmvc.modelandview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 此类是：Springmvc 的ModelAndView
 * @author hpc
 * @2017年2月17日下午10:51:42
 */
@Controller
public class SpringmvcModelAndView {
	/**
	 * 目标方法的返回值可以是 ModelAndView 类型。 
	 * 其中可以包含视图和模型信息
	 * SpringMVC 会把 ModelAndView 的 model 中数据放入到 request 域对象中. 
	 */
	@RequestMapping("/springmvcModelAndView")
	public ModelAndView springmvcModelAndView(){
		// 创建ModelAndView用于携带model和视图
		ModelAndView mv = new ModelAndView();
		// 添加指定要显示的视图名字
		mv.setViewName("success");
		// 添加model(以键值对的方式)，会将其存入到request域中去
		mv.addObject("name", "dyn");
		//返回ModelAndView
		return mv;
	}
	
}

