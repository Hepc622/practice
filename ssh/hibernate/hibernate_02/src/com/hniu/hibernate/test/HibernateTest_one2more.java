package com.hniu.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.bean.one2more.Customer;
import com.hniu.hibernate.bean.one2more.Order;
import com.hniu.hibernate.factroy.HibernateSessionFactroy;

public class HibernateTest_one2more {

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

	@Test
	public void one2MoreDelete() {
		Order order = (Order) session.load(Order.class, 5);
		session.delete(order);
		// 不能直接饮用一个被引用的数据，需要使用级联的方式进行删除
		Object object = session.get(Customer.class, 3);
		session.delete(object);
	}

	@Test
	public void one2MoreUpdate() {
		Order order = (Order) session.get(Order.class, 2);
		Customer Customer = (com.hniu.hibernate.bean.one2more.Customer) session.get(Customer.class, 1);
		/*
		 * 获取到的order中的customer对象也是一个代理对象，只有在使用的时候才会去查找
		 * 如果session关闭了还去调用customer对象会出现懒加载异常
		 */
		Customer customer = order.getCustomer();
		customer.setName("CCC");
	}

	@Test
	@SuppressWarnings("unused")
	public void one2MoreSave() {
		Customer customer1 = new Customer("AAA");
		Order order1 = new Order("111", customer1);
		Order order2 = new Order("222", customer1);

		Customer customer2 = new Customer("BBB");
		Order order3 = new Order("111", customer2);
		Order order4 = new Order("222", customer2);

		// 存入对象的时候要先存入1的一方在存n的一方这样可以减少sql的update语句，在一定程度上提高了效率
		session.save(customer2);
		session.save(order3);
		session.save(order4);
	}
}
