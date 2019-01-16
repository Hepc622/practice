package com.hniu.spring.strus.servletlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStrusServletListener implements ServletContextListener {
	public SpringStrusServletListener() {
		// TODO Auto-generated constructor stub
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// 获取ioc容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-strus.xml");
		// 获取application域对象
		ServletContext context = arg0.getServletContext();
		// 将ioc容器放到application域中去
		context.setAttribute("ioc", ac);
	}

}
