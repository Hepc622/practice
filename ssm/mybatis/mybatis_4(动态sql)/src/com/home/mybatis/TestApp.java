package com.home.mybatis;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.home.entity.User;

public class TestApp {
	public static void main(String[] args) throws IOException {
		// �ҽ���ȡsession�Ĵ����װ����һ�������ֱ࣬���ù���������ȡsession
		SqlSession session = SessionUtils.getSession("mybatis.xml");
		String loadUser = "com.home.mapper.loadUser";
		// ���᲻�ᶯ̬��ȥ��ȡ��������Ӧ����ִ��if��ǩ��sql,�û�ΪidΪ4��
		User user = session.selectOne(loadUser, new User(4, null, null));
		System.out.println("���᲻�ᶯ̬��ȥ��ȡ��������Ӧ����ִ��if��ǩ��sql,�û�ΪidΪ4��");
		System.out.println(user);
		// ���᲻�ᶯ̬��ȥ��ȡ��������Ӧ����ִ��otherwise��ǩ��sql,�û�Ϊhpc��
		user = session.selectOne(loadUser, new User(2, null, null));
		System.out.println("���᲻�ᶯ̬��ȥ��ȡ��������Ӧ����ִ��otherwise��ǩ��sql,�û�Ϊhpc��");
		System.out.println(user);
		// ���᲻�ᶯ̬��ȥ��ȡ��������Ӧ����ִ��when��ǩ��sql,�û�ΪAA��
		user = session.selectOne(loadUser, new User(5, null, null));
		System.out.println("���᲻�ᶯ̬��ȥ��ȡ��������Ӧ����ִ��when��ǩ��sql,�û�Ϊ5��");
		System.out.println(user);
		// ������䣨�����ǩ��
		// String insertUser = "com.home.mapper.insertUser";
		// List<User> list = new ArrayList<User>();
		// list.add(new User("AA", "123"));
		// list.add(new User("BB", "123"));
		// list.add(new User("CC", "123"));
		// list.add(new User("DD", "123"));
		// list.add(new User("EE", "123"));
		// session.insert(insertUser, list);
		
		// �������
//		String updateUser = "com.home.mapper.updateUser";
//		session.update(updateUser,new User(4,"FF","123"));
		// ���������Ե�������ȥ
		session.commit();
		// �ر�session
		session.close();
	}
}
