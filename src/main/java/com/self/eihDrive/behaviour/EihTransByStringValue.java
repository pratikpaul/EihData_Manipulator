package com.self.eihDrive.behaviour;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EihTransByStringValue<T> implements EihTransBehaviourForObj<T> {

	public T act(SessionFactory factory, Object obj1, Object obj2, Object obj3) {
		T result = null;
		String fromTable = (String) obj1;
		String value = (String) obj2;
		String col = (String) obj3;
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			String queryStr = "from " + fromTable + " where " + col + "= :input";
			Query query = session.createQuery(queryStr);
			query.setParameter("input", value);
			result = (T) query.uniqueResult();
			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public T act(SessionFactory factory, Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		return null;
	}

	public T act(SessionFactory factory, Object obj1) {
		// TODO Auto-generated method stub
		return null;
	}

}
