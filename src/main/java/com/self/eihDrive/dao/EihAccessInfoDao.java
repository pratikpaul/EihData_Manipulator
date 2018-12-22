package com.self.eihDrive.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.self.eihDrive.behaviour.EihTransToGetByQuery;
import com.self.eihDrive.behaviour.EihTransToGetFromDB;
import com.self.eihDrive.behaviour.EihTransToGetListByQuery;
import com.self.eihDrive.behaviour.EihTransToInsert;
import com.self.eihDrive.behaviour.EihTransToUpdate;
import com.self.eihDrive.dto.EihAccessInfo;

public class EihAccessInfoDao extends EihDaoAbstract<EihAccessInfo> implements Dao<EihAccessInfo> {

	public void insert(SessionFactory factory, EihAccessInfo input) {
		setTransBehaviour(new EihTransToInsert<EihAccessInfo>());
		justTakeAction(factory, input);
	}

	public void update(SessionFactory factory, EihAccessInfo input) {
		setTransBehaviour(new EihTransToUpdate<EihAccessInfo>());
		justTakeAction(factory, input);
	}

	public Boolean delete(SessionFactory factory, EihAccessInfo input) {
		return null;
	}

	public EihAccessInfo getFromDb(SessionFactory factory, String fromTable, int value) {
		return null;
	}
	
	public EihAccessInfo getFromDB(SessionFactory factory, String fromTable, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public EihAccessInfo getFromDB(SessionFactory factory, String fromTable, Object value1, Object value2) {
		return null;
	}

	public List<EihAccessInfo> getFromDb(SessionFactory factory, String fromTable) {
		setTransBehaviourForList(new EihTransToGetFromDB<EihAccessInfo>());
		List<EihAccessInfo> results = takeActionAndGetList(factory, fromTable);
		
		return results;
	}

	public EihAccessInfo getByQuery(SessionFactory factory, String query) {

		setTransBehaviourForObj(new EihTransToGetByQuery<EihAccessInfo>());
		EihAccessInfo result = takeActionAndGetObj(factory, query);

		return result;
	}

	public List<EihAccessInfo> getListByQuery(SessionFactory factory, String query) {
		setTransBehaviourForList(new EihTransToGetListByQuery<EihAccessInfo>());
		List<EihAccessInfo> results = takeActionAndGetList(factory, query);
		return results;
	}

	public EihAccessInfo getFromDB(SessionFactory factory, String fromTable, Object name, String col) {
		return null;
	}

	public EihAccessInfo getFromDB(SessionFactory factory, String fromTable, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
}
