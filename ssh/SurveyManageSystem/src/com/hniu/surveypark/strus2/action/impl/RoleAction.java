package com.hniu.surveypark.strus2.action.impl;

import java.util.ArrayList;
import java.util.List;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.model.Role;
import com.hniu.surveypark.service.RoleService;
import com.hniu.surveypark.strus2.action.BaseAction;

/**
 * �����ǣ���ɫAction
 * 
 * @author: hpc
 * @version: 2016��12��13�� ����4:23:51
 */
public class RoleAction extends BaseAction<Role>{

	private static final long serialVersionUID = -7258398211329678019L;
	private RoleService roleService;
	private List<Role> list;
	private List<Right> notinc;
	private String[] include;

	public void setInclude(String[] include) {
		this.include = include;
	}

	public List<Right> getNotinc() {
		return notinc;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Right> getInc() {
		return new ArrayList(this.model.getRole_right());
	}

	public List<Role> getList() {
		return list;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * ȥ��ɫҳ��
	 */
	public String toRole() {
		this.list = roleService.getAllRole();
		return "toRole";
	}

	/**
	 * ȥ��ӽ�ɫҳ��
	 */
	public String toAddRole() {
		// û��ȡ��ɫ���е�Ȩ��
		this.notinc = roleService.getRoleNotInclude(this.model.getRole_right());
		return "toAddRole";
	}

	/**
	 * ��ӽ�ɫ
	 */
	public String addRole() {
		roleService.saveOrUpdate(this.model, include);
		return "addRole";
	}

	/**
	 * ȥȨ�ޱ༭ҳ��
	 */
	public String toEditRole() {
		this.model = roleService.getRole(this.model.getRole_id());
		// û��ȡ��ɫ���е�Ȩ��
		this.notinc = roleService.getRoleNotInclude(this.model.getRole_right());
		return "toEditRole";
	}

	/**
	 * Ȩ�ޱ༭
	 */
	public String editRole() {
		return addRole();
	}

	/**
	 * ɾ����ɫ
	 */
	public String deleteRole() {
		roleService.deleteRole(this.model);
		return "addRole";
	}
}
