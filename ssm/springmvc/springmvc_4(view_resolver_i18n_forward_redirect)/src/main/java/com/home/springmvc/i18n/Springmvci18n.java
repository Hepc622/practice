package com.home.springmvc.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �����ǣ�this is springmvc i18n example
 *  If use internationalization(i18n)
 *  you must set resourceBundleMessageSource bean in file of springmvc.xml 
 * @author hpc
 * @2017��2��19������10:39:44
 */
@Controller
public class Springmvci18n {
	@RequestMapping("/springmvcInternationalization")
	public String springmvcInternationalization(){
		System.out.println("This is springmvc internationalization");
		return "success";
	}
	
}
