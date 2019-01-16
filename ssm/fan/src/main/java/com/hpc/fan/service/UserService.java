package com.hpc.fan.service;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.User;

/**
 * class：This is UserService
 * @author hpc
 * @2017年4月1日下午9:08:08
 */
public interface UserService {
	/**
	 * get one entity with name
	 * 
	 * @param name
	 * @return
	 */
	public User getUserEntity(@Param("user_name") String name);

	/**
	 * save one entity
	 * 
	 * @param user
	 */
	public void saveUserEntity(User user);

	/**
	 * update a entity
	 */
	public void updateUserEntity(User user);
}
