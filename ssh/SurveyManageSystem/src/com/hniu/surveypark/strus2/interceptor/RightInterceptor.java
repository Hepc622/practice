package com.hniu.surveypark.strus2.interceptor;

import java.util.Map;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.model.User;
import com.hniu.surveypark.strus2.action.UserAware;
import com.hniu.surveypark.strus2.action.impl.LoginAction;
import com.hniu.surveypark.strus2.action.impl.RegisterAction;
import com.hniu.surveypark.util.ValidateUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 此类是：权限拦截器
 * 
 * @author: hpc
 * @version: 2016年12月23日 下午10:18:58
 */
public class RightInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	/**
	 * 实现拦截器方法
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		// 获取Action代理对象
		ActionProxy proxy = arg0.getProxy();
		// 通过InvocationContext获取session
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		
		// 获取session中的对象
		User user = (User) session.get("user");
		
		if (proxy.getAction() instanceof UserAware) {
			// 注入user对象
			((UserAware) proxy.getAction()).setUser(user);
		}
		if (proxy.getAction() instanceof LoginAction||proxy.getAction() instanceof RegisterAction) {
			return arg0.invoke();
		}
		// 获取命名空间
		String namespace = proxy.getNamespace();
		// 获取Action名字
		String actionName = proxy.getActionName();
		if (!ValidateUtil.isEmpty(actionName) || namespace.contains("/")) {
			namespace = "";
		}
		String url = "";
		url = namespace + "/" + actionName;
		// 获取application
		@SuppressWarnings("unchecked")
		Map<String, Right> map = (Map<String, Right>) arg0.getInvocationContext().getApplication().get("all_right");		
		// 获取Right
		Right right = map.get(url);
		if (right != null && right.getRight_open()) {
			return arg0.invoke();
		} else {
			if (user != null) {
				if(user.getUser_name().equals("super"))
					return arg0.invoke();
				long[] sum = user.getRightSum();
				long l = sum[right.getRight_pos()];
				if ((l & right.getRight_code()) != 0) {
					return arg0.invoke();
				} else {
					return "notRight";
				}
			} 
		}
		return "notRight";
	}
}
