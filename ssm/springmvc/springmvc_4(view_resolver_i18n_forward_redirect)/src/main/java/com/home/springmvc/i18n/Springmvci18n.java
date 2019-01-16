package com.home.springmvc.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此类是：this is springmvc i18n example
 *  If use internationalization(i18n)
 *  you must set resourceBundleMessageSource bean in file of springmvc.xml 
 * @author hpc
 * @2017年2月19日上午10:39:44
 */
@Controller
public class Springmvci18n {
	@RequestMapping("/springmvcInternationalization")
	public String springmvcInternationalization(){
		System.out.println("This is springmvc internationalization");
		return "success";
	}
	
}
