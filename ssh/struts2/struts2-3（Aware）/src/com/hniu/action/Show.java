package com.hniu.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class Show {
	public String execute() {
		// 从web中获取资源
		// 通过actionContext对象获取,上下文
		ActionContext actionContext = ActionContext.getContext();
		// 获取application域里的资源,通过上下文获取application
//		Map<String, Object> application = actionContext.getApplication();
		// 设置属性
		Map<String, Object> application = (Map<String, Object>)
				actionContext.get("application");
		application.put("a", "application");
		// 获取属性
		System.out.println(application.get("application"));
		// 获取session域里的资源,通过上下文获取session
		 Map<String, Object> session = actionContext.getSession();
//		Map<String, Object> session = (Map<String, Object>) actionContext
//				.get("session");
		// 设置属性
		session.put("s", "session");
		// 获取属性
		System.out.println(session.get("session"));
		// 获取request域中的资源,通过上下文获取request（只能获取在这里是不能设置值的）他返回的是数组形式的
		Map<String, String[]> request = (Map<String, String[]>) actionContext
				.get("request");

		// 不能在这里设置属性
		// 获取属性
//		System.out.println(((String[]) request.get("name"))[0]);
		return "success";
	}
}
