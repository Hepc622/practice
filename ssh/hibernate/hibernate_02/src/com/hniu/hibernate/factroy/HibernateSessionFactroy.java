package com.hniu.hibernate.factroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class HibernateSessionFactroy {

	private static ServiceRegistry serviceRegistry;
	private static Configuration config;
	private static SessionFactory sessionFactory;
	private static Session session;

	private HibernateSessionFactroy() {
	}

	static {
		config = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
	}

	public static SessionFactory getSessionFatroy() {
		return sessionFactory;
	}

	public static Session getSession() {
		return session;
	}

	public static void close() {
		session.close();
		sessionFactory.close();
	}
}
