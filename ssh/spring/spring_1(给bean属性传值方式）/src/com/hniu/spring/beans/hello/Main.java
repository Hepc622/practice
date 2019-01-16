package com.hniu.spring.beans.hello;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 对象的创建
		// Hello hello = new Hello();
		// 对属性赋值
		// hello.setName("hello spring!");
		// spring框架ioc容器实现 对象的创建和对属性赋值
		// applicationcontenxt 的实现类是ClassPathXmlApplicationContext，获取类路径下的xml文件
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext(
				"beans_hello.xml");
		// 从ioc容器中获取你要的bean对象
		// Hello hello = (Hello) cpxac.getBean("hello");
		// 调用方法
		// hello.showName();
		// 通过类对象从ioc容器中获取
		//Phone phone = cpxac.getBean(Phone.class);
		//System.out.println(phone);
//		Phone phone = (Phone) cpxac.getBean("phone2");
//		System.out.println(phone);
		
		Person person = (Person) cpxac.getBean("person2");
		System.out.println(person);
	}

}
