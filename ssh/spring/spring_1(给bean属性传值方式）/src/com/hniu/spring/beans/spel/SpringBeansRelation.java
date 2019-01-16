package com.hniu.spring.beans.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansRelation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext(
				"beans_spel.xml");
		Person person = (Person) cpxac.getBean("person");
		System.out.println(person);

	}

}
