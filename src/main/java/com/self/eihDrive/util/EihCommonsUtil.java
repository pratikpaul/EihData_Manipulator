package com.self.eihDrive.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EihCommonsUtil {
	
	public static void persistEihObject(SessionFactory factory, Object... obj) {
		try {
			Session session = factory.openSession();
			session.beginTransaction();

			for (Object ob : obj) {
				session.save(ob);
			}

			session.getTransaction().commit();
			session.close();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
}
