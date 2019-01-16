package com.home.springmvc.ant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此类是：Springmvc Ant 风格匹配url
 * 	? 匹配一个任意的字符
 * 	* 匹配任意字符
 * 	** 匹配多层任意字符
 * @author hpc
 * @2017年2月16日下午10:08:46
 */
@Controller
public class SpringMvcAnt {
	//	? 匹配一个任意的字符
	@RequestMapping("/springmvc/?/antUrl1")
	public String antUrl3() {
		System.out.println("? 匹配一个任意的字符");
		return "success";
	}
	//* 匹配任意字符
	@RequestMapping("/springmvc/*/antUrl2")
	public String antUrl() {
		System.out.println("* 匹配任意字符");
		return "success";
	}
	//** 匹配多层任意字符
	@RequestMapping("/springmvc/**/antUrl3")
	public String antUrl2() {
		System.out.println("** 匹配多层任意字符");
		return "success";
	}
}
