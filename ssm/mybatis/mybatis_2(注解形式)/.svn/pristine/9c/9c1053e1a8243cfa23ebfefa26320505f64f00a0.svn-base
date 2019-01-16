package com.home.mybatis;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.home.entity.User;
import com.home.entityInterface.UserMapperInterface;
import com.home.mybatis.utils.SessionUtils;

public class TestApp {
	public static void main(String[] args) throws IOException {
		// 我将获取session的代码封装成了一个工具类，直接用工具类来获取session
		SqlSession session = SessionUtils.getSession("mybatis.xml");
		// 通过接口，直接使用session.getMapper(接口.class);获取到接口
		UserMapperInterface mapper = session.getMapper(UserMapperInterface.class);
		// 再调用接口的方法，去执行接口所注解的sql语句
		System.out.println(mapper.insertUser(new User(null,"mh", "123")));
		System.out.println(mapper.updateUser(new User(3, "hpc", "123")));
		System.out.println(mapper.deleteUser(new User(3, null, null)));
		System.out.println(mapper.loadUser(new User(1, null, null)));
		// 将数据属性到数据中去
		session.commit();
		// 关闭session
		session.close();
	} 
}
