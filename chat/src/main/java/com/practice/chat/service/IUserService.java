package com.practice.chat.service;

import java.util.List;

import com.practice.chat.bean.User;

public interface IUserService {
	// 	获取用户
	public List<User> getUserByNames(String name);
	
	//  添加用户
	public int saveUser(User user);
	//  修改用户
	public int updateUser(User user);
	//  删除用户
	public int deleteUser(String userId);
}
