package com.hniu.spring.jdbcTemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcTemplate {
	private UserDao userDao;
	private ApplicationContext ac;
	{
		ac = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		userDao = (UserDao) ac.getBean("userDao");
	}
	@Test
	public void con(){
		System.out.println(userDao.getUser(1));
	}
}
