package com.hniu.surveypark.strus2.action.impl;

import java.util.ArrayList;
import java.util.List;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.model.Role;
import com.hniu.surveypark.service.RoleService;
import com.hniu.surveypark.strus2.action.BaseAction;

/**
 * 此类是：角色Action
 * 
 * @author: hpc
 * @version: 2016年12月13日 下午4:23:51
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
	 * 去角色页面
	 */
	public String toRole() {
		this.list = roleService.getAllRole();
		return "toRole";
	}

	/**
	 * 去添加角色页面
	 */
	public String toAddRole() {
		// 没获取角色已有的权限
		this.notinc = roleService.getRoleNotInclude(this.model.getRole_right());
		return "toAddRole";
	}

	/**
	 * 添加角色
	 */
	public String addRole() {
		roleService.saveOrUpdate(this.model, include);
		return "addRole";
	}

	/**
	 * 去权限编辑页面
	 */
	public String toEditRole() {
		this.model = roleService.getRole(this.model.getRole_id());
		// 没获取角色已有的权限
		this.notinc = roleService.getRoleNotInclude(this.model.getRole_right());
		return "toEditRole";
	}

	/**
	 * 权限编辑
	 */
	public String editRole() {
		return addRole();
	}

	/**
	 * 删除角色
	 */
	public String deleteRole() {
		roleService.deleteRole(this.model);
		return "addRole";
	}
}
