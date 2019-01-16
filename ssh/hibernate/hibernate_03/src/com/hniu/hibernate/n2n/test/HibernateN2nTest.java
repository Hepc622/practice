package com.hniu.hibernate.n2n.test;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hniu.hibernate.factroy.HibernateSessionFactroy;
import com.hniu.hibernate.n2n.bean.Categorie;
import com.hniu.hibernate.n2n.bean.Item;


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
	public void hibernateN2nGet(){
		Categorie categorie = (Categorie) session.get(Categorie.class, 1);
		System.out.println(categorie.getName());
	} 
	
	@Test
	public void hibernateN2nSave() {
		Categorie categorie1 = new Categorie();
		categorie1.setName("C-AA");
		
		Categorie categorie2 = new Categorie();
		categorie2.setName("C-BB");
		
		Item item1 = new Item();
		item1.setName("I-AA");
		
		Item item2 = new Item();
		item2.setName("I-BB");	
		
		categorie1.getItem().add(item1);
		categorie1.getItem().add(item2);
		categorie2.getItem().add(item1);
		categorie2.getItem().add(item2);
		
		item1.getCategorie().add(categorie1);
		item1.getCategorie().add(categorie2);
		item2.getCategorie().add(categorie1);
		item2.getCategorie().add(categorie2);

		session.save(categorie1);
		session.save(categorie2);
		session.save(item1);
		session.save(item2);
	}
}
