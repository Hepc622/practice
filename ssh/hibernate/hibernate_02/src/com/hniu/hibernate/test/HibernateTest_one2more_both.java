package com.hniu.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.bean.one2more.both.*;
import com.hniu.hibernate.factroy.HibernateSessionFactroy;

public class HibernateTest_one2more_both {

	private Session session;
	private Transaction transaction;

	@Before
	public void inite() {
		session = HibernateSessionFactroy.getSession();
		transaction = session.beginTransaction();
	}

	@After
	public void distroy() {
		transaction.commit();
		session.close();
	}

	/*
	 * 想要删除一个被引用的对象，就要在级联对象中设置一个cascade="delete",这样才能进行删除 <set cascade="delete">
	 * 和这对象关联的所有级联对象删除
	 * 
	 * <set cascade="delete-orphan">
	 * 
	 * <set cascade="save-update"> 级联插入，随着1的一端进行插入，一般在开发中不这么使用，建议手动插入
	 * 
	 */
	@Test
	public void saveCascaeSave_update() {
		Customer customer2 = new Customer("AAA");
		Order order3 = new Order("333", customer2);
		Order order4 = new Order("444", customer2);
		customer2.getOrders().add(order3);
		customer2.getOrders().add(order4);
		session.save(customer2);
	}

	@Test
	public void one2MoreBothCascade() {
		Customer customer = (Customer) session.get(Customer.class, 2);
		session.delete(customer);
	}

	@Test
	public void one2MoreBothDelete() {
		Customer customer = (Customer) session.get(Customer.class, 2);
		session.delete(customer);
	}

	@Test
	public void one2MoreBothUpdate() {
		Customer customer = (Customer) session.get(Customer.class, 1);
		customer.getOrders().iterator().next().setOrderName("hpc");
	}

	@Test
	public void one2MoreBothGet() {
		Customer customer = (Customer) session.get(Customer.class, 2);
		for (Order order : customer.getOrders()) {
		}
		session.close();
		for (Order order : customer.getOrders()) {
			System.out.println(order);
		}
		// customer的内置是一个hibernate框架的set,也是一种懒加载模式
		// System.out.println(customer.getOrders().getClass().getName());
	}

	@Test
	public void one2MoreBothSave() {
		Customer customer2 = new Customer("BBB");
		Order order3 = new Order("111", customer2);
		Order order4 = new Order("222", customer2);
		// 存入对象的时候要先存入1的一方在存n的一方这样可以减少sql的update语句，在一定程度上提高了效率
		session.save(customer2);
		session.save(order3);
		session.save(order4);
	}
}
