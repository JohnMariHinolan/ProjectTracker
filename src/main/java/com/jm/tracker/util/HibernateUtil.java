package com.jm.tracker.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.jm.tracker.obj.RemarksObj;
import com.jm.tracker.obj.Tags;
import com.jm.tracker.obj.TaskInfo;
import com.jm.tracker.obj.TaskObj;
import com.jm.tracker.obj.UserObj;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	@PersistenceContext
	private static EntityManagerFactory emf;

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(TaskObj.class);
			configuration.addAnnotatedClass(TaskInfo.class);
			configuration.addAnnotatedClass(Tags.class);
			configuration.addAnnotatedClass(UserObj.class);
			configuration.addAnnotatedClass(RemarksObj.class);
			System.out.println("Hibernate Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate serviceRegistry created");

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
