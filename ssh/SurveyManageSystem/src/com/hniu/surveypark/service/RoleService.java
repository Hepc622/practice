package com.hniu.surveypark.service;

import java.util.List;
import java.util.Set;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.model.Role;

/**
 * �����ǣ���ɫService
 * 
 * @author: hpc
 * @version: 2016��12��12�� ����10:38:08
 */
public interface RoleService {

	/**
	 * ��ȡ���еĽ�ɫ
	 */
	List<Role> getAllRole();

	/**
	 * ��ȡ���ã����ڻ���
	 */
	Role getRole(Integer role_id);

	/**
	 * �����ڸý�ɫ��Ȩ��
	 */
	List<Right> getRoleNotInclude(Set<Right> role_right);

	/**
	 * �����ɫ�����
	 */
	void saveOrUpdate(Role model, String[] include);

	/**
	 * ɾ����ɫ
	 */
	void deleteRole(Role model);

}
