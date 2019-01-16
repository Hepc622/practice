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
 * �����ǣ�Ȩ��������
 * 
 * @author: hpc
 * @version: 2016��12��23�� ����10:18:58
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
	 * ʵ������������
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		// ��ȡAction�������
		ActionProxy proxy = arg0.getProxy();
		// ͨ��InvocationContext��ȡsession
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		
		// ��ȡsession�еĶ���
		User user = (User) session.get("user");
		
		if (proxy.getAction() instanceof UserAware) {
			// ע��user����
			((UserAware) proxy.getAction()).setUser(user);
		}
		if (proxy.getAction() instanceof LoginAction||proxy.getAction() instanceof RegisterAction) {
			return arg0.invoke();
		}
		// ��ȡ�����ռ�
		String namespace = proxy.getNamespace();
		// ��ȡAction����
		String actionName = proxy.getActionName();
		if (!ValidateUtil.isEmpty(actionName) || namespace.contains("/")) {
			namespace = "";
		}
		String url = "";
		url = namespace + "/" + actionName;
		// ��ȡapplication
		@SuppressWarnings("unchecked")
		Map<String, Right> map = (Map<String, Right>) arg0.getInvocationContext().getApplication().get("all_right");		
		// ��ȡRight
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
