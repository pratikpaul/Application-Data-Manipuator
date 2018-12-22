package com.self.appData.behaviour;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransToUpdate<T> implements TransBehaviour<T> {

	public void act(SessionFactory factory, T... obj) {
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			for (T ob : obj) {
				session.update(ob);
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
