package com.home.springmvc.requestparams;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * �����ǣ�RequestParamsע�� ��ȡ�������
 * 
 * @RequestParam(value="userAge",required=false) value����Ҫӳ���name
 *                                               required:�Ƿ�����и�ֵ��Ĭ����true
 *                                               defaultValue:��һ��Ĭ�ϵ�ֵ
 * @author hpc
 * @2017��2��17������11:26:14
 */
@Controller
public class SpringmvcRequestParams {
	/**
	 * @RequestParamע��
	 */
	@RequestMapping(value = "/requestParams", method = RequestMethod.GET)
	public String requestParams(@RequestParam("userName") String userName, @RequestParam("userSex") String userSex,
			@RequestParam(value = "userAge", required = false, defaultValue = "0") int userAge) {
		System.out.println("�û�����" + userName + "," + "�Ա�" + userSex + "," + "���䣺" + userAge);
		return "success";
	}

	/**
	 * @CookieValueע��
	 */
	@RequestMapping("/cookieValue")
	public String cookieValue(@CookieValue("JSESSIONID") String cookie, HttpServletRequest request) {
		request.getParameter("key");
		System.out.println("@CookieValueע��:" + cookie);
		return "success";
	}
}
