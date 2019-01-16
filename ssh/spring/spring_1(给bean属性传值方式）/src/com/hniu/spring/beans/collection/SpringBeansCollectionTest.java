package com.hniu.spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansCollectionTest {

	public static void main(String[] args) {
		// 创建一个ioc容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_collection.xml");

		// 获取容器中的bean对象
//		Person person = ac.getBean(Person.class);
		Person personMap = (Person) ac.getBean("personMap");
		Person personSet = (Person) ac.getBean("personSet");
		Person pNameSpace = (Person) ac.getBean("pNameSpace");
		System.out.println(personMap);
		System.out.println(personSet);
		System.out.println(pNameSpace);
	}

}
