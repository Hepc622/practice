package com.hpc.fan.dao;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.User;

/**
 * class：This is UserDao
 * 
 * @author hpc
 * @2017年3月15日下午9:52:14
 */
public interface UserDao {

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
