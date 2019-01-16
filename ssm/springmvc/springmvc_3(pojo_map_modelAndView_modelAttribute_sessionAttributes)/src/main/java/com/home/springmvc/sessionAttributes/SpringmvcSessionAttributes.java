package com.home.springmvc.sessionAttributes;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 此类是：@SessionAttributes用于存放数据至session中
 * @author hpc
 * @2017年2月17日下午11:18:28
 */
@SessionAttributes("name")
@Controller
public class SpringmvcSessionAttributes {
	/**
	 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
	 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
	 * 
	 * 注意: 该注解只能放在类的上面. 而不能修饰放方法. 
	 */
	@RequestMapping("/springmvcSessionAttributes")
	public String springmvcSessionAttributes(Map<String,Object> map){
		map.put("name", "dynltx");
		return "success";
	}
	
}
