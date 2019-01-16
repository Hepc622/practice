package com.hniu.surveypark.strus2.action.impl;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.UserService;
import com.hniu.surveypark.strus2.action.BaseAction;
import com.hniu.surveypark.util.DataUtil;

/**
 * �û�ע��
 */
public class RegisterAction extends BaseAction<User> {
	private static final long serialVersionUID = 1L;
	private UserService<User> userService;

	public void setUserService(UserService<User> userService) {
		this.userService = userService;
	}

	/**
	 * ȥע��ҳ��
	 * 
	 * @return
	 */
	@SkipValidation // ������֤
	public String toRegister() {
		return "register";
	}

	/**
	 * ע����Ϣ
	 * 
	 * @return
	 */
	public String register() {
		// ���������
		model.setUser_password(DataUtil.encryptionMD5(model.getUser_password()));
		// �����û�
		userService.saveEntity(model);
		return SUCCESS;
	}

	/**
	 * �ֶ�У�� �����ݽ���У��
	 */
	public void validate() {
		// У���Ƿ�������û�������
		String user_email = model.getUser_email();
		if (userService.isExsitEmail(user_email)) {
			addFieldError("user_email", "���������");
		}
		// System.out.println(model.getUser_name());
		// // ��֤�û����Ƿ�Ϊ��
		// if (ValidateUtil.isEmpty(this.model.getUser_name())) {
		// addFieldError("user_name", "�û�������Ϊ��");
		// }
		// // ��֤�ǳ��Ƿ�Ϊ��
		// if (ValidateUtil.isEmpty(this.model.getUser_nickname())) {
		// addFieldError("user_nickname", "�ǳƲ���Ϊ��");
		// }
		// // ��֤�����Ƿ�Ϊ��
		// if (ValidateUtil.isEmpty(this.model.getUser_email())) {
		// addFieldError("user_email", "���䲻��Ϊ��");
		// }
		// // ��֤�����Ƿ�Ϊ��
		// if (ValidateUtil.isEmpty(this.model.getUser_password())) {
		// addFieldError("user_password", "���벻��Ϊ��");
		// }
		// // ����������֤����˴���Ͳ�������
		// if (hasFieldErrors()) {
		// return;
		// }
	}
}
