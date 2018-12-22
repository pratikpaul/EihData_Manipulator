package com.self.eihDrive.behaviour;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EihTransToGetByQuery<T> implements EihTransBehaviourForObj<T> {

	public T act(SessionFactory factory, Object obj1, Object obj2, Object obj3) {
		// TODO Auto-generated method stub
		return null;
	}

	public T act(SessionFactory factory, Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		return null;
	}

	public T act(SessionFactory factory, Object obj1) {
		T res = null;
		String query = (String) obj1;
		try {
			Session session = factory.openSession();
			session.beginTransaction();

			Query q = session.createQuery(query);
			res = (T) q.uniqueResult();

			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

}
