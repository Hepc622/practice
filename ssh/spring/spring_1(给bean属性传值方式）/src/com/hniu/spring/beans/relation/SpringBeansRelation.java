package com.hniu.spring.beans.relation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansRelation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext(
				"beans_relation.xml");
		Person person = (Person) cpxac.getBean("person");
		System.out.println(person);
		person = (Person) cpxac.getBean("person2");
		System.out.println(person);
	}

}
