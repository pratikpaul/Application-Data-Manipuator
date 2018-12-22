package com.self.appData.behaviour;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.self.appData.dto.AccessInfo;

public class TransToGetListByQuery<T> implements TransBehaviourForList<T> {

	public List<T> act(SessionFactory factory, Object obj) {
		List<T> results = null;
		String query = (String) obj;
		try {
			Session session = factory.openSession();
			session.beginTransaction();

			Query q = session.createQuery(query);
			results = (List<T>) q.list();

			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return results;
	}

}
