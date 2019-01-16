package com.hniu.surveypark.strus2.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.service.RightService;
import com.hniu.surveypark.util.ValidateUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 此类是： 捕获权限 
 * @author:	hpc 
 * @version: 2016年12月25日 下午8:53:55 
 */ 
public class CatchRightInterceptor implements Interceptor, ServletContextAware {
	private static final long serialVersionUID = 4694621468627191065L;
	private ServletContext sc;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取Spring 容器
		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(ServletActionContext.getServletContext());
		// 获取权限服务
		RightService rightService = (RightService) applicationContext.getBean("rightServiceImpl");
		// 获取Action代理对象
		ActionProxy proxy = invocation.getProxy();
		// 获取命名空间
		String namespace = proxy.getNamespace();
		// 获取Action名字
		String actionName = proxy.getActionName();
		String url = "";
		if (!ValidateUtil.isEmpty(actionName) || namespace.contains("/")) {
			namespace = "";
		}
		url = namespace + "/" + actionName;
		@SuppressWarnings("unchecked")
		Map<String, Right> all_right = (Map<String, Right>) sc.getAttribute("all_right");
		Right r = all_right.get(url);
		if (r != null) {
			return invocation.invoke();
		} else {
			Right right = new Right(url);
			// 保存权限
			rightService.saveOrUpdateRight(right);
			// 获取出该url权限
			right = rightService.getRight(right.getRight_url());
			// 不等于空将它保存在servletContex中
			if (right != null)
				all_right.put(right.getRight_url(), right);
			return invocation.invoke();
		}
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.sc = arg0;
	}

}
