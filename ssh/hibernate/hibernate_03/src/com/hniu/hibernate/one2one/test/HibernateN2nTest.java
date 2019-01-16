package com.hniu.hibernate.one2one.test;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.factroy.HibernateSessionFactroy;
import com.hniu.hibernate.n2n.bean.*;


public class HibernateN2nTest {
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
	public void hibernateOne2OneSave() {
	}
}
