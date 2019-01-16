package com.home.springmvc.map;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此类是：Map参数传入
 * 
 * @author hpc
 * @2017年2月17日下午7:42:53
 */
@Controller
public class SpringmvcMap {
	@RequestMapping("/springmvcMap")
	public String springmvcMap(Map<String, Object> map) {
		// 该map会被放入到request域中去
		map.put("name", "hpc");
		return "success";
	}
}
