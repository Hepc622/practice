package com.hniu.spring.strus2.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.hniu.spring.strus.bean.User;

public class SpringStrusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SpringStrusServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取application对象取出ioc域对象
		ServletContext context = getServletContext();
		ApplicationContext ioc = (ApplicationContext) context.getAttribute("ioc");
		// 获取域中的对象
		User user = ioc.getBean(User.class);
		System.out.println(user.getName());
	}
}
