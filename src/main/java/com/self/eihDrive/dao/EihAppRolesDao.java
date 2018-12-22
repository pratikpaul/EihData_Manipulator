package com.self.eihDrive.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.self.eihDrive.behaviour.EihTransToGetByCond;
import com.self.eihDrive.behaviour.EihTransToInsert;
import com.self.eihDrive.dto.EihAccessInfo;
import com.self.eihDrive.dto.EihAppRoles;
import com.self.eihDrive.util.EihCommonsUtil;

public class EihAppRolesDao extends EihDaoAbstract<EihAppRoles> implements Dao<EihAppRoles> {

	public void insert(SessionFactory factory, EihAppRoles input) {
		setTransBehaviour(new EihTransToInsert<EihAppRoles>());
		justTakeAction(factory, input);
	}

	public void update(SessionFactory factory, EihAppRoles input) {

	}

	public Boolean delete(SessionFactory factory, EihAppRoles input) {
		return null;
	}

	public EihAppRoles getFromDb(SessionFactory factory, String fromTable, int value) {

		return null;
	}
	
	public EihAppRoles getFromDB(SessionFactory factory, String fromTable, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public EihAppRoles getFromDB(SessionFactory factory, String fromTable, Object value1, Object value2) {
		return null;
	}

	public List<EihAppRoles> getFromDb(SessionFactory factory, String fromTable) {
		return null;
	}

	public EihAppRoles getByQuery(SessionFactory factory, String query) {
		return null;
	}

	public List<EihAppRoles> getListByQuery(SessionFactory factory, String query) {
		return null;
	}

	public EihAppRoles getFromDB(SessionFactory factory, String fromTable, Object value, String col) {

		setTransBehaviourForObj(new EihTransToGetByCond<EihAppRoles>());
		EihAppRoles result = takeActionAndGetObj(factory, fromTable, value, col);

		return result;
	}

	public EihAppRoles getFromDB(SessionFactory factory, String fromTable, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
