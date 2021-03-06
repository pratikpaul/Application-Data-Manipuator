package com.self.appData.behaviour;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TransToGetFromDB<T> implements TransBehaviourForList<T>{

	public List<T> act(SessionFactory factory, Object obj) {
		List<T> result = null;
		String fromTableStr = (String) obj;
		try {
			Session session = factory.openSession();
			session.beginTransaction();

			String queryStr = "from " + fromTableStr + " where mark_delete = 0";
			Query query = session.createQuery(queryStr);
			result = (List<T>) query.list();

			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
