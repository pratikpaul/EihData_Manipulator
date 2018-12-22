package com.self.eihDrive.behaviour;

import java.util.List;

import org.hibernate.SessionFactory;

public interface EihTransBehaviourForList<T> {
	public List<T> act(SessionFactory factory, Object obj);
}
