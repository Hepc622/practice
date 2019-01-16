package com.hniu.springmvc.format;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hniu.springmvc.bean.User;

/**
 * class：This is Springmvc format test
 * 
 * @author hpc
 * @2017年2月24日下午3:27:08
 */
@Controller
public class SpringmvcFormat {

	@RequestMapping("/springmvcFormat")
	public String springmvcFormat(User user) {
		System.out.println(user);
		return "success";
	}
}
