package com.spring.jdbc.hibernater;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

public class SpringHibernateJdbc {
	private HibernateTransactionManager htm;
	private ApplicationContext ac;
	{
		ac = new ClassPathXmlApplicationContext("application.xml");
	}
	@Test
	public void hibernateTest() throws SQLException{
		DataSource dataSource = (DataSource) ac.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
}
