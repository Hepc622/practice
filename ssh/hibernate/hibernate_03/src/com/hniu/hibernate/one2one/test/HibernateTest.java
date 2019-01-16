package com.hniu.hibernate.one2one.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.factroy.HibernateSessionFactroy;
import com.hniu.hibernate.one2one.bean.Department;
import com.hniu.hibernate.one2one.bean.Manager;

public class HibernateTest {
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		session = HibernateSessionFactroy.getSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destroy(){
//		transaction.commit();
//		session.close();
	}

	@Test
	public void hibernateOne2OneGet(){
		Department department = (Department) session.get(Department.class, 1);
		System.out.println(department.getName());
		// 当session关闭的时候，再使用代替对象时会产生懒加载异常
		session.close();
		System.out.println(department.getManager().getName());
	}
	
	@Test
	public void hibernateOne2OneSave() {
		Manager manager = new Manager();
		Manager manager2 = new Manager();
		Department department = new Department();
		Department department2 = new Department();
		
		manager.setDepartment(department);
		manager.setName("人事部经理");
		department.setName("人事部");
		department.setManager(manager);
		
		manager2.setDepartment(department2);
		manager2.setName("行政部经理");
		department2.setName("行政部");
		department2.setManager(manager2);

		session.save(manager);
		session.save(manager2);
		session.save(department);
		session.save(department2);
		
	}
}
