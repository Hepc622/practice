package com.home.mybatis;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.home.entity.Student;
import com.home.entity.Teacher;

public class TestApp {
	public static void main(String[] args) throws IOException {
		// 我将获取session的代码封装成了一个工具类，直接用工具类来获取session
		SqlSession session = SessionUtils.getSession("mybatis.xml");
		String loadTeacher="com.home.entity.teacherMapper.loadTeacher";
		String loadStudent="com.home.entity.studentMapper.loadStudent";
		Student student = session.selectOne(loadStudent,4);
		Teacher teacher = session.selectOne(loadTeacher,1);
		System.out.println(student);
		System.out.println(teacher);
		// 将数据属性到数据中去
		session.commit();
		// 关闭session
		session.close();
	} 
}
