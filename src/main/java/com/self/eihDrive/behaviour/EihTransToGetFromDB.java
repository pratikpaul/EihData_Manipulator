package com.self.eihDrive.behaviour;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EihTransToGetFromDB<T> implements EihTransBehaviourForList<T> {

	public List<T> act(SessionFactory factory, Object obj) {
		List<T> result = null;
		String fromTableStr = (String) obj;
		try {
			Session session = factory.openSession();
			session.beginTransaction();

			String queryStr = "from " + fromTableStr;
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
