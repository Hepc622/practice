package com.hniu.springmvc.transverter;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * class：This is Converter SpringmvcConverter 
 * @author hpc
 * @2017年2月23日下午5:05:33
 */
@Controller
public class SpringmvcConverter {
	@RequestMapping("/converterStringToDate")
	public String converterStringToDate(@RequestParam(value="date")Date date){
		System.out.println("String to Date:"+date);
 		return "success";
	}
}
