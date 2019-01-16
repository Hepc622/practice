package com.hniu.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.bean.News;
import com.hniu.hibernate.bean.Pay;
import com.hniu.hibernate.bean.Work;
import com.hniu.hibernate.factroy.HibernateSessionFactroy;

public class HibernateTest {

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
	public void hibernateComponent() {
		Work work = new Work("何鹏程");
		Pay pay = new Pay(12000, 120000, 5, work);
		work.setPay(pay);
		session.save(work);

		Work work2 = (Work) session.get(Work.class, 1);
		System.out.println(work2.getPay().getYearSalary());
	}

	@Test
	public void hibernateFormal() {
		News news = (News) session.get(News.class, 2);
	}

	@Test
	public void hibernateTest() throws InterruptedException {
		News news = new News("hpc", "622", new Date());
		session.save(news);
		// 是当前线程睡3秒，模范多线程并发 
		// Thread.sleep(3000,1000);
		news.setPassword("995622"); 
	}
}
