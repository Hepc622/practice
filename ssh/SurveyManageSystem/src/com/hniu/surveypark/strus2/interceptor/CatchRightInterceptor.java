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
 * �����ǣ� ����Ȩ�� 
 * @author:	hpc 
 * @version: 2016��12��25�� ����8:53:55 
 */ 
public class CatchRightInterceptor implements Interceptor, ServletContextAware {
	private static final long serialVersionUID = 4694621468627191065L;
	private ServletContext sc;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// ��ȡSpring ����
		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(ServletActionContext.getServletContext());
		// ��ȡȨ�޷���
		RightService rightService = (RightService) applicationContext.getBean("rightServiceImpl");
		// ��ȡAction�������
		ActionProxy proxy = invocation.getProxy();
		// ��ȡ�����ռ�
		String namespace = proxy.getNamespace();
		// ��ȡAction����
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
			// ����Ȩ��
			rightService.saveOrUpdateRight(right);
			// ��ȡ����urlȨ��
			right = rightService.getRight(right.getRight_url());
			// �����ڿս���������servletContex��
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
