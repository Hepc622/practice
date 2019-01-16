package com.hniu.surveypark.service.impl;

import java.util.HashSet;
import java.util.List;

import com.hniu.surveypark.dao.impl.RoleDao;
import com.hniu.surveypark.model.Role;
import com.hniu.surveypark.model.User;
import com.hniu.surveypark.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService<User> {
	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * 判断是否存在对应字段
	 */
	public boolean isExsitEmail(String str) {
		String hql = "from User as u where u.user_email=?";
		List<User> list = this.findEntityByHQL(hql, str);
		return list.size() > 0 ? true : false;
	}

	/**
	 * 登陆验证用户密码
	 */
	public User loginValidate(String email, String password) {
		String hql = "from User u where u.user_email=? and u.user_password=?";
		List<User> list = this.findEntityByHQL(hql, email, password);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<User> getAllUser() {
		String hql = "from User";
		return this.findEntityByHQL(hql);
	}

	@Override
	public List<Role> getNotRole(List<Role> inc) {
		String inRole = "";
		String hql = "";
		if (inc != null && inc.size() > 0) {
			for (Role role : inc) {
				inRole += role.getRole_id() + ",";
			}
			hql = "from Role r where r.role_id not in(" + inRole.substring(0, inRole.length() - 1) + ")";
		} else {
			hql = "from Role";
		}
		return roleDao.findEntityByHQL(hql);
	}

	@Override
	public void saveOrUpdateEntity(User model, Integer[] inc) {
		User user = this.getEntity(model.getUser_id());
		String inRole = "";
		if (inc != null && inc.length > 0) {
			for (Integer in : inc) {
				inRole += in.intValue() + ",";
			}
			String hql = "from Role r where r.role_id in(" + inRole.substring(0, inRole.length() - 1) + ")";
			List<Role> role = roleDao.findEntityByHQL(hql);
			user.setUser_role(new HashSet<Role>(role));
			saveOrUpdateEntity(user);
		}
	}

	@Override
	public void deleteUserRole(User model) {
		User user = this.getEntity(model.getUser_id());
		user.setUser_role(null);
	}
}
