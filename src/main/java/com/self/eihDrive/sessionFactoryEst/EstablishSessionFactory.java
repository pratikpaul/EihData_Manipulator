package com.self.eihDrive.sessionFactoryEst;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EstablishSessionFactory {
	private static SessionFactory sessionFactory;

	private static Configuration getConfiguration(String jdbcUrl, String schema) {

		Configuration conf = new Configuration();
		conf.setProperty("hibernate.connection.url", jdbcUrl + schema);
		return conf;
	}
	
	public static SessionFactory createSessionFactory(String jdbcUrl, String schema) {
		try {
			if (sessionFactory == null)
				sessionFactory = getConfiguration(jdbcUrl, schema).configure().buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
			// throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}
}
