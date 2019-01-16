package com.hniu.surveypark.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hniu.surveypark.dao.impl.RightDao;
import com.hniu.surveypark.dao.impl.RoleDao;
import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.model.Role;
import com.hniu.surveypark.service.RoleService;

/**
 * 此类是：RoleService实现
 * 
 * @author: hpc
 * @version: 2016年12月12日 下午10:39:57
 */
public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;
	private RightDao rightDao;

	public void setRightDao(RightDao rightDao) {
		this.rightDao = rightDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public List<Role> getAllRole() {
		String hql = "from Role";
		return roleDao.findEntityByHQL(hql);
	}

	public Role getRole(Integer roleId) {
		return roleDao.getEntity(roleId);
	}

	public List<Right> getRoleNotInclude(Set<Right> role_right) {
		if (!role_right.isEmpty()) {
			String inRight = "";
			for (Right right : role_right) {
				inRight += right.getRight_id() + ",";
			}
			String hql = "from Right r where r.right_id not in(" + inRight.substring(0, inRight.length() - 1) + ")";
			return rightDao.findEntityByHQL(hql);
		} else {
			String hql = "from Right r";
			return rightDao.findEntityByHQL(hql);
		}
	}

	public void saveOrUpdate(Role model, String[] include) {
		String inRight = "";
		if (include.length > 0) {
			for (String string : include) {
				inRight += string + ",";
			}
			String hql = "from Right r where r.right_id in(" + inRight.substring(0, inRight.length() - 1) + ")";
			List<Right> right = rightDao.findEntityByHQL(hql);
			model.setRole_right(new HashSet<Right>(right));
			roleDao.saveOrUpdateEntity(model);
		}
	}

	@Override
	public void deleteRole(Role model) {
		roleDao.deleteEntity(model);
	}
}
