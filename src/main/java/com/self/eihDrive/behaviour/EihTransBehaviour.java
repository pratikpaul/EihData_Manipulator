package com.self.eihDrive.behaviour;

import org.hibernate.SessionFactory;

public interface EihTransBehaviour<T> {
	public void act(SessionFactory factory, T... obj);
}
