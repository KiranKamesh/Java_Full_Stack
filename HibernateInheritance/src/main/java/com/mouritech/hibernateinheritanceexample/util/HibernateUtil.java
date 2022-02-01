package com.mouritech.hibernateinheritanceexample.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.mouritech.hibernateinheritanceexample.entity.BankAccount;
import com.mouritech.hibernateinheritanceexample.entity.SavingsAccount;
import com.mouritech.hibernateinheritanceexample.entity.CurrentAccount;



public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration cfg = new Configuration();
				
				//Hibernate settings equivalent to hibernate.cfg.xml properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernatesample");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS,"root");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				
				cfg.setProperties(settings);
				cfg.addAnnotatedClass(BankAccount.class);
				cfg.addAnnotatedClass(CurrentAccount.class);
				cfg.addAnnotatedClass(SavingsAccount.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
													.applySettings(cfg.getProperties()).build();
				System.out.println("Hibernate Java Configuration Service Registry Created....");
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}