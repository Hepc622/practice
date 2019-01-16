package com.hpc.fan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpc.fan.bean.User;
import com.hpc.fan.dao.UserDao;
import com.hpc.fan.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public User getUserEntity(String name) {
		return userDao.getUserEntity(name);
	}

	@Override
	public void saveUserEntity(User user) {
		userDao.saveUserEntity(user);
	}

	@Override
	public void updateUserEntity(User user) {
		userDao.updateUserEntity(user);
	}

}
