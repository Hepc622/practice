package com.hniu.springmvc.initbinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hniu.springmvc.bean.User;

/**
 * class：This is controller Springmvc init binder
 * 
 * @author hpc
 * @2017年2月23日下午6:42:54
 */
@Controller
public class SpringmvcInitBinder {

	@RequestMapping("/springmvcInitBinder")
	public String springmvcInitBinder(User user) {
		System.out.println(user);
		return "success";
	}
	
	/**
	 * use for setting some one field available or unavailable
	 * use for bind bean data
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("userNumber");
		webDataBinder.setAllowedFields("userName");
	}
}
