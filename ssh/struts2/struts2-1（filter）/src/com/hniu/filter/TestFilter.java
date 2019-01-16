package com.hniu.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest sr = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;
		// 获取url的参数
		String url = sr.getServletPath().substring(1);
		// 判断
		if ("info.action".equals(url)) {
			sr.getRequestDispatcher("/WEB-INF/pages/setInfo.jsp").forward(sr, rp);
			return;
		}
		if ("showInfo.action".equals(url)) {
			String Id = sr.getParameter("productID");
			String name = sr.getParameter("productName");
			String price = sr.getParameter("productPrice");
			Product product = new Product();
			product.setId(Id);
			product.setName(name);
			product.setPrice(price);
			sr.setAttribute("product", product);
			sr.getRequestDispatcher("/WEB-INF/pages/showInfo.jsp").forward(sr, rp);
			return;
		}
		 chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
