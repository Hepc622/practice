package com.hniu.surveypark.service;

import java.util.List;

import com.hniu.surveypark.model.Role;

/**
 * user Service
 */
public interface UserService<User> extends BaseService<User> {
	/**
	 * ��֤�����Ƿ����
	 */
	public boolean isExsitEmail(String str);

	/**
	 * ��½��֤
	 */
	public User loginValidate(String email, String password);

	/**
	 * ��ȡ���е��û�
	 */
	public List<User> getAllUser();

	/**
	 * ��ȡ�û�û�еĽ�ɫ
	 */
	public List<Role> getNotRole(List<Role> inc);

	/**
	 * ���������û���Ȩ��
	 * @return 
	 */
	public void saveOrUpdateEntity(User model, Integer[] inc);

	/**
	 * ����û���ɫ
	 */
	public void deleteUserRole(User model);

}
