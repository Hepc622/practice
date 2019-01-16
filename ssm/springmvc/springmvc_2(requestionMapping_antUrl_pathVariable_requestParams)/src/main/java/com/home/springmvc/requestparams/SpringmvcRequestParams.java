package com.home.springmvc.requestparams;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 此类是：RequestParams注解 获取请求参数
 * 
 * @RequestParam(value="userAge",required=false) value：需要映射的name
 *                                               required:是否必须有该值，默认是true
 *                                               defaultValue:给一个默认的值
 * @author hpc
 * @2017年2月17日上午11:26:14
 */
@Controller
public class SpringmvcRequestParams {
	/**
	 * @RequestParam注解
	 */
	@RequestMapping(value = "/requestParams", method = RequestMethod.GET)
	public String requestParams(@RequestParam("userName") String userName, @RequestParam("userSex") String userSex,
			@RequestParam(value = "userAge", required = false, defaultValue = "0") int userAge) {
		System.out.println("用户名：" + userName + "," + "性别：" + userSex + "," + "年龄：" + userAge);
		return "success";
	}

	/**
	 * @CookieValue注解
	 */
	@RequestMapping("/cookieValue")
	public String cookieValue(@CookieValue("JSESSIONID") String cookie, HttpServletRequest request) {
		request.getParameter("key");
		System.out.println("@CookieValue注解:" + cookie);
		return "success";
	}
}
