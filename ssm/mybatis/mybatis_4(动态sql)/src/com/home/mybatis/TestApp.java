package com.home.mybatis;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.home.entity.User;

public class TestApp {
	public static void main(String[] args) throws IOException {
		// 我将获取session的代码封装成了一个工具类，直接用工具类来获取session
		SqlSession session = SessionUtils.getSession("mybatis.xml");
		String loadUser = "com.home.mapper.loadUser";
		// 看会不会动态的去获取，按理论应该是执行if标签的sql,用户为id为4的
		User user = session.selectOne(loadUser, new User(4, null, null));
		System.out.println("看会不会动态的去获取，按理论应该是执行if标签的sql,用户为id为4的");
		System.out.println(user);
		// 看会不会动态的去获取，按理论应该是执行otherwise标签的sql,用户为hpc的
		user = session.selectOne(loadUser, new User(2, null, null));
		System.out.println("看会不会动态的去获取，按理论应该是执行otherwise标签的sql,用户为hpc的");
		System.out.println(user);
		// 看会不会动态的去获取，按理论应该是执行when标签的sql,用户为AA的
		user = session.selectOne(loadUser, new User(5, null, null));
		System.out.println("看会不会动态的去获取，按理论应该是执行when标签的sql,用户为5的");
		System.out.println(user);
		// 插入语句（插入标签）
		// String insertUser = "com.home.mapper.insertUser";
		// List<User> list = new ArrayList<User>();
		// list.add(new User("AA", "123"));
		// list.add(new User("BB", "123"));
		// list.add(new User("CC", "123"));
		// list.add(new User("DD", "123"));
		// list.add(new User("EE", "123"));
		// session.insert(insertUser, list);
		
		// 更新语句
//		String updateUser = "com.home.mapper.updateUser";
//		session.update(updateUser,new User(4,"FF","123"));
		// 将数据属性到数据中去
		session.commit();
		// 关闭session
		session.close();
	}
}
