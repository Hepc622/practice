package com.home.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {
	public static SqlSession getSession(String resource) {
		// ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		InputStream is = TestApp.class.getClassLoader().getResourceAsStream(resource);
		// ����SqlSessionFactory,ͨ��SqlSessionFactory����ȡsession
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		// ͨ��SqlSessionFactory��ȡsession
		SqlSession session = sf.openSession();
		return session;
	}
}
