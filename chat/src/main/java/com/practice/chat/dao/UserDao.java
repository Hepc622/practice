package com.practice.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.practice.chat.bean.User;

/**
 * @author Administrator
 *	用户Dao
 */
@Repository
public interface UserDao {
	//根据用户名获取用户信息	
	public List<User> findUserByName(@Param("email") String name);
}
