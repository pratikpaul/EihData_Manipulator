package com.self.eihDrive.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.self.eihDrive.behaviour.EihTransBehaviour;
import com.self.eihDrive.behaviour.EihTransBehaviourForBool;
import com.self.eihDrive.behaviour.EihTransBehaviourForList;
import com.self.eihDrive.behaviour.EihTransBehaviourForObj;

public abstract class EihDaoAbstract<T> {
	public EihTransBehaviourForList<T> transBehaviourForList;
	public EihTransBehaviour<T> transBehaviour;
	public EihTransBehaviourForBool<T> transBehaviourForBool;
	public EihTransBehaviourForObj<T> transBehaviourForObj;

	public EihTransBehaviourForList<T> getTransBehaviourForList() {
		return transBehaviourForList;
	}

	public void setTransBehaviourForList(EihTransBehaviourForList<T> transBehaviourForList) {
		this.transBehaviourForList = transBehaviourForList;
	}

	public EihTransBehaviour<T> getTransBehaviour() {
		return transBehaviour;
	}

	public void setTransBehaviour(EihTransBehaviour<T> transBehaviour) {
		this.transBehaviour = transBehaviour;
	}

	public EihTransBehaviourForBool<T> getTransBehaviourForBool() {
		return transBehaviourForBool;
	}

	public void setTransBehaviourForBool(EihTransBehaviourForBool<T> transBehaviourForBool) {
		this.transBehaviourForBool = transBehaviourForBool;
	}

	public EihTransBehaviourForObj<T> getTransBehaviourForObj() {
		return transBehaviourForObj;
	}

	public void setTransBehaviourForObj(EihTransBehaviourForObj<T> transBehaviourForObj) {
		this.transBehaviourForObj = transBehaviourForObj;
	}
	
	public void justTakeAction(SessionFactory factory, T obj) {
		transBehaviour.act(factory, obj);
	}

	public Boolean takeActionAndGetBool(SessionFactory factory, T obj) {
		return transBehaviourForBool.act(factory, obj);
	}

	public T takeActionAndGetObj(SessionFactory factory, Object obj1, Object obj2, Object obj3) {
		return transBehaviourForObj.act(factory, obj1, obj2, obj3);
	}

	public T takeActionAndGetObj(SessionFactory factory, Object obj1, Object obj2) {
		return transBehaviourForObj.act(factory, obj1, obj2);
	}

	public T takeActionAndGetObj(SessionFactory factory, Object obj1) {
		return transBehaviourForObj.act(factory, obj1);
	}

	public List<T> takeActionAndGetList(SessionFactory factory, Object obj) {
		return transBehaviourForList.act(factory, obj);
	}
}
