package com.hniu.surveypark.service;

import java.util.List;
import java.util.Set;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.model.Role;

/**
 * 此类是：角色Service
 * 
 * @author: hpc
 * @version: 2016年12月12日 下午10:38:08
 */
public interface RoleService {

	/**
	 * 获取所有的角色
	 */
	List<Role> getAllRole();

	/**
	 * 获取觉得，用于回显
	 */
	Role getRole(Integer role_id);

	/**
	 * 不属于该角色的权限
	 */
	List<Right> getRoleNotInclude(Set<Right> role_right);

	/**
	 * 保存角色或更新
	 */
	void saveOrUpdate(Role model, String[] include);

	/**
	 * 删除角色
	 */
	void deleteRole(Role model);

}
