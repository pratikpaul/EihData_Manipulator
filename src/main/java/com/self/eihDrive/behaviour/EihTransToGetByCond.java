package com.self.eihDrive.behaviour;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.self.eihDrive.dto.EihAppRoles;
import com.self.eihDrive.dto.EihApps;

public class EihTransToGetByCond<T> implements EihTransBehaviourForObj<T> {

	public T act(SessionFactory factory, Object obj1, Object obj2, Object obj3) {
		T result = null;
		String fromTable = (String) obj1;
		int id = ((Integer) obj2).intValue();
		String col = (String) obj3;
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			// Query query = session.createQuery("select max(roleId) from EihAppRoles where
			// appId= :app_id");
			String queryStr = "from " + fromTable + " where roleId = (select max(roleId) from " + fromTable + " where "
					+ col + "= :input)";
			Query query = session.createQuery(queryStr);
			query.setParameter("input", id);
			result = (T) query.uniqueResult();

			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public T act(SessionFactory factory, Object obj1, Object obj2) {
		return null;
	}

	public T act(SessionFactory factory, Object obj1) {
		// TODO Auto-generated method stub
		return null;
	}

}
