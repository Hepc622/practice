package com.hniu.surveypark.strus2.action.impl;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.UserService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.util.DataUtil;

/**
 * 用户注册
 */
public class RegisterAction extends BaseAction<User> {
	private static final long serialVersionUID = 1L;
	private UserService<User> userService;

	public void setUserService(UserService<User> userService) {
		this.userService = userService;
	}

	/**
	 * 去注册页面
	 * 
	 * @return
	 */
	@SkipValidation // 跳过验证
	public String toRegister() {
		return "register";
	}

	/**
	 * 注册信息
	 * 
	 * @return
	 */
	public String register() {
		// 将密码加密
		model.setUser_password(DataUtil.encryptionMD5(model.getUser_password()));
		// 保存用户
		userService.saveEntity(model);
		return SUCCESS;
	}

	/**
	 * 手动校验 对数据进行校验
	 */
	public void validate() {
		// 校验是否存在了用户和邮箱
		String user_email = model.getUser_email();
		if (userService.isExsitEmail(user_email)) {
			addFieldError("user_email", "该邮箱存在");
		}
		// System.out.println(model.getUser_name());
		// // 验证用户名是否为空
		// if (ValidateUtil.isEmpty(this.model.getUser_name())) {
		// addFieldError("user_name", "用户名不能为空");
		// }
		// // 验证昵称是否为空
		// if (ValidateUtil.isEmpty(this.model.getUser_nickname())) {
		// addFieldError("user_nickname", "昵称不能为空");
		// }
		// // 验证邮箱是否为空
		// if (ValidateUtil.isEmpty(this.model.getUser_email())) {
		// addFieldError("user_email", "邮箱不能为空");
		// }
		// // 验证密码是否为空
		// if (ValidateUtil.isEmpty(this.model.getUser_password())) {
		// addFieldError("user_password", "密码不能为空");
		// }
		// // 如果上面的验证添加了错误就不往下走
		// if (hasFieldErrors()) {
		// return;
		// }
	}
}
