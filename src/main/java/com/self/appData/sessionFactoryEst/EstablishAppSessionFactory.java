package com.self.appData.sessionFactoryEst;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EstablishAppSessionFactory {
	private static SessionFactory sessionFactory;

	private static Configuration getConfiguration(String jdbcUrl, String schema) {
		Configuration conf = new Configuration();
		conf.setProperty("hibernate.connection.url", jdbcUrl + schema);
		// conf.setProperty("hibernate.connection.url", "jdbc:mysql://198.168.0.8:3306/"
		// + "EIH_AUTHORIZATION");
		return conf;
	}

	public static SessionFactory createSessionFactory(String jdbcUrl, String schema) {
		try {
			if (sessionFactory == null)
				sessionFactory = getConfiguration(jdbcUrl, schema).configure("AppDataHibernate.cfg.xml")
						.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
