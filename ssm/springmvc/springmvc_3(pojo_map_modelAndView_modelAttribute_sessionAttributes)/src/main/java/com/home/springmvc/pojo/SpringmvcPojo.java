package com.home.springmvc.pojo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.bean.User;

/**
 * 此类是：springmvc pojo 
 * @author hpc
 * @2017年2月17日下午7:01:04
 */
@Controller
public class SpringmvcPojo {
	
	/**
	 * 直接将表单中的数据映射到User中去
	 * 	支持级联映射
	 * 表单名字必须与pojo属性一直
	 */
	@RequestMapping("/springmvcPojo")
	public String springmvcPojo(User user){
		System.out.println(user);
		return "success";
	}
}
