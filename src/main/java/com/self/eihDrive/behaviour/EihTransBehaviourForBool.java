package com.self.eihDrive.behaviour;

import org.hibernate.SessionFactory;

public interface EihTransBehaviourForBool<T> {
	public Boolean act(SessionFactory factory, T obj);
}
