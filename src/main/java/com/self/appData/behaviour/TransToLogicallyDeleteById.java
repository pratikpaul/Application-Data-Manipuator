package com.self.appData.behaviour;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransToLogicallyDeleteById<T> implements TransBehaviourForDelete<T> {

	public Boolean act(SessionFactory factory, Object input, Class<?> c) {
		T obj;
		int id = (Integer)input;
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			obj = (T) session.load(c, id);
			session.delete(obj);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	}
