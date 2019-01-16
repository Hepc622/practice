package com.hniu.spring.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansScope {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_scope.xml");
		Person person1 = ac.getBean(Person.class);
		Person person2 = ac.getBean(Person.class);
		System.out.println(person1==person2);
		
	}

}
