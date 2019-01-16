package com.hniu.hibernate.joined_subclass.test;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.factroy.HibernateSessionFactroy;
import com.hniu.hibernate.joined_subclass.bean.*;
/**
 * joined-subclass的继承映射关系
 * 		优点：
 * 			1.没有插入辨别者列
 * 			2.子类表能有自己的特定约束
 * 			
 * 		缺点：
 * 			1.多差查询的时候会多表查询，会使效率降低
 */
public class HibernateSubclass {
	private Session session;
	private Transaction beginTransaction;

	@Before
	public void init() {
		session = HibernateSessionFactroy.getSession();
		beginTransaction = session.beginTransaction();
	}

	@After
	public void distroy() {
		beginTransaction.commit();
		session.close();
	}

	@Test
	public void hibernateSubclassSelect() {
		Person person = (Person) session.get(Person.class, 1);
		List<Student> list = session.createQuery("from Student").list();
		System.out.println(list.toString());
	}

	@Test
	public void hibernateSubclassSave() {
		Person person = new Person();
		person.setName("hpc");
		person.setAge(20);
		person.setSex(true);

		session.save(person);

		Student student = new Student();
		student.setAge(21);
		student.setName("hpc");
		student.setSex(true);
		student.setClazz("java 1403");

		session.save(student);

		Student student2 = new Student();
		student2.setAge(21);
		student2.setName("lyl");
		student2.setSex(true);
		student2.setClazz("图像 1403");

		session.save(student2);
	}
}
