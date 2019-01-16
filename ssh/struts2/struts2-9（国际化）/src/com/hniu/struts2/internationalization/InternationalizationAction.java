package com.hniu.struts2.internationalization;

import com.opensymphony.xwork2.ActionSupport;

public class InternationalizationAction extends ActionSupport {
	private String text;
	private String text2;

	public String excute() {
		// 通过DefaultTextProvider的getText方法获取配置文件中的属性
		text = getText("userName");
		text2 = getText("password");
		System.out.println(text+text2);
		return SUCCESS;
	}
}
