package com.home.springmvc.view;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �����ǣ�internalResourceView JstlView
 *  If you use jstl tags in jsp
 *  the springmvc will transform internalResourceView to jstlView 
 * @author hpc
 * @2017��2��19������10:08:11
 */
@Controller
public class InternalResourceViewChangeToJstlView {
	@RequestMapping("/internalResourceViewChangeToJstlView")
	public String internalResourceViewChangeToJstlView(Map<String,Object> map) {
		map.put("name", "hpc");
		System.out.println("internalresourceView change to jstlView");
		return "success";
	}
}
