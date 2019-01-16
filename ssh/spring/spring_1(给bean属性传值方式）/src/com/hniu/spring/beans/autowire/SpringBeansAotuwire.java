package com.hniu.spring.beans.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansAotuwire {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(
				"beans_autowire.xml");
		//以beans的名字进行自动配置
		Person personAotuwire_byName = (Person) cpxa
				.getBean("personAotuwire_byName");
		//以beans的类型进行自动配置
		Person personAotuwire_byType = (Person) cpxa
		.getBean("personAotuwire_byType");
		System.out.println(personAotuwire_byName);
		System.out.println(personAotuwire_byType);
	}

}
