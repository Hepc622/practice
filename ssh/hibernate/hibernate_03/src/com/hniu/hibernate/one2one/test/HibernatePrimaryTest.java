package com.hniu.hibernate.one2one.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.factroy.HibernateSessionFactroy;
import com.hniu.hibernate.one2one.bean.primary.*;

public class HibernatePrimaryTest {
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		session = HibernateSessionFactroy.getSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
	}

	@Test
	public void hibernateOne2OneGet() {

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

		// 这里因为department的主键是以manager的主键作为主键，
		// 所以必须要先执行manager，的到其主键在执行department
		session.save(department);
		session.save(department2);
		session.save(manager);
		session.save(manager2);

	}
}
