package com.framework.core.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.framework.core.model.AppUser;
import com.framework.core.model.Client;
import com.framework.core.model.Organization;

public class HibernateConfig {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xm
			return new Configuration().configure().
					addAnnotatedClass(Client.class).addAnnotatedClass(Organization.class).addAnnotatedClass(AppUser.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
