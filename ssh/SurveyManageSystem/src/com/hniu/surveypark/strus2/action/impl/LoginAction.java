package com.hniu.surveypark.strus2.action.impl;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.RightService;
import com.hniu.surveypark.service.UserService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.util.DataUtil;

/**
 * 用户登录
 */
public class LoginAction extends BaseAction<User> implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private UserService<User> userService;
	private RightService rightService;

	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	public void setUserService(UserService<User> userService) {
		this.userService = userService;
	}

	/**
	 * 去登陆页面
	 */
	public String toLogin() {
		return "index";
	}

	public String login() {
		if(model!=null){
			return SUCCESS;
		}
		return null;
	}

	/**
	 * 登录信息校验
	 */
	// 跳过验证的方式有多种一个是@SkipValidation一个是validate+要验证的方法名
	public void validateDoLogin() {
		// 查询对应的用户
		User user = userService.loginValidate(model.getUser_email(), DataUtil.encryptionMD5(model.getUser_password()));
		// 验证是否有该用户
		if (user != null) {
			// 获取当前权限位
			int maxPos = rightService.getMaxPos();
			user.setRightSum(new long[(maxPos + 1)]);//初始化权限位数组的最大值
			user.initRigth();
			session.put("user", user);
		} else {
			if (!userService.isExsitEmail(model.getUser_email())) {
				addFieldError("user_email", "没有该邮箱");
			} else {
				addFieldError("user_password", "密码错误");
			}
		}
	}

	/**
	 * 注入原生态session
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
