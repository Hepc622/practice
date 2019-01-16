package com.hpc.fan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * class��This is IndexInterceptor
 * 
 * @author hpc
 * @2017��3��11������5:51:47
 */
public class IndexInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// ���session��û��navs��˵������û�о�����ҳ
		HttpSession session = request.getSession();
		if (session != null) {
			Object navs = session.getAttribute("navs");
			if (navs == null) {
				response.sendRedirect("/");
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
