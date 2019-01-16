package com.home.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {
	public static SqlSession getSession(String resource) {
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = TestApp.class.getClassLoader().getResourceAsStream(resource);
		// 构建SqlSessionFactory,通过SqlSessionFactory来获取session
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		// 通过SqlSessionFactory获取session
		SqlSession session = sf.openSession();
		return session;
	}
}
