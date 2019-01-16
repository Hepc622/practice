package com.hniu.surveypark.service;

import java.util.List;

import com.hniu.surveypark.model.Role;

/**
 * user Service
 */
public interface UserService<User> extends BaseService<User> {
	/**
	 * 验证邮箱是否存在
	 */
	public boolean isExsitEmail(String str);

	/**
	 * 登陆验证
	 */
	public User loginValidate(String email, String password);

	/**
	 * 获取所有的用户
	 */
	public List<User> getAllUser();

	/**
	 * 获取用户没有的角色
	 */
	public List<Role> getNotRole(List<Role> inc);

	/**
	 * 保存或更新用户的权限
	 * @return 
	 */
	public void saveOrUpdateEntity(User model, Integer[] inc);

	/**
	 * 清楚用户角色
	 */
	public void deleteUserRole(User model);

}
