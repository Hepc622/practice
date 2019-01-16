package com.home.springmvc.ant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �����ǣ�Springmvc Ant ���ƥ��url
 * 	? ƥ��һ��������ַ�
 * 	* ƥ�������ַ�
 * 	** ƥ���������ַ�
 * @author hpc
 * @2017��2��16������10:08:46
 */
@Controller
public class SpringMvcAnt {
	//	? ƥ��һ��������ַ�
	@RequestMapping("/springmvc/?/antUrl1")
	public String antUrl3() {
		System.out.println("? ƥ��һ��������ַ�");
		return "success";
	}
	//* ƥ�������ַ�
	@RequestMapping("/springmvc/*/antUrl2")
	public String antUrl() {
		System.out.println("* ƥ�������ַ�");
		return "success";
	}
	//** ƥ���������ַ�
	@RequestMapping("/springmvc/**/antUrl3")
	public String antUrl2() {
		System.out.println("** ƥ���������ַ�");
		return "success";
	}
}
