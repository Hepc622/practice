package com.hniu.tepyconversion;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class TepyConversion extends ActionSupport {
	private static final long serialVersionUID = -4172261426427670965L;
	private Integer age;
	/*
	 * 基本类型的转换 在拦截对action属性赋值时，如果类型不正确，不回给出任何的提示。将不会属性赋予值
	 * 
	 * 我问将错误信息要提示，就要实现ValidactionAware接口的方式来实现
	 * 可以直接继承ActionSupport类，它实现了ValidactionAware接口 且要写一个name为input的result
	 * 
	 * 如何覆盖默认的错误提示 在Action所在包建一个配置文件，文件名以Action类名命名
	 * 在配置文件中写入对应的键值对，invalid.fieldvalue.fielName=xxx
	 * 
	 * 在simple主题下不会自动显示出来，要通过标签来显示我要想要的内容 
	 * 	1 通过fielderror标签来显示错误信息
	 * 	2但是这样会显示成列表形式显示出阿里 
	 * 	3 我们可以通过替换一下template.simple,且替 换一下里面的fielderroe.ftl文件
	 * 	4将里面的ul,li,span标签去掉就可以了 
	 * 	5 在显示页面通过fielderror的fieldName属性来显示错误信息
	 * 引用类型的转换（通过定义转换器来实现） 为什么要定义类型转换器，如果是一个string类型的怎么转换成一个引用类型 
	 * 	如何定义个类型转换器
	 *		 开发类型转换器的类：扩展一下strutsTypeConverter类 配置类型转换器 
	 *		 方式一 基于字段的配置
	 * 			在字段的model下创建一个ModelClassName-conversion.properties 在该文件中写入键值对
	 * 			fieldName=类型转换器的全名
	 * 		 方式二 基于类型的配置 在src目录下创建一个xwork-conversion.properties
	 * 			在该配置文件中写入键值对 待转类型=类型转换器的全名
	 */
	private Date date;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String conversion() {
		return "success";
	}
}
