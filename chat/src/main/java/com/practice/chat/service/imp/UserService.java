package com.practice.chat.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.chat.bean.User;
import com.practice.chat.dao.UserDao;
import com.practice.chat.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserDao userDao;
	public List<User> getUserByNames(String name) {
		return userDao.findUserByName(name);
	}

	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
