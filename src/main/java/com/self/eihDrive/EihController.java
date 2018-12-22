package com.self.eihDrive;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.self.eihDrive.dao.Dao;
import com.self.eihDrive.dao.EihDaoFactory;
import com.self.eihDrive.dao.EihDaoType;
import com.self.eihDrive.dto.EihAccessInfo;
import com.self.eihDrive.dto.EihAppRoles;
import com.self.eihDrive.dto.EihApps;
import com.self.eihDrive.sessionFactoryEst.EstablishSessionFactory;

public class EihController {

	private static volatile EihController instance = null;
	private static EihDaoFactory daoFactory = new EihDaoFactory();
	private static String jdbcUrl;
	private static String schema;
	private static SessionFactory factory = null;

	private EihController(String jdbcUrl, String schema) {
		this.jdbcUrl = jdbcUrl;
		this.schema = schema;
		factory = EstablishSessionFactory.createSessionFactory(jdbcUrl, schema);
	}

	public static EihController getInstance(String jdbcUrl, String schema) {
		if (instance == null) {
			synchronized (EihController.class) {
				if (instance == null) {
					instance = new EihController(jdbcUrl, schema);
				}
			}
		}
		return instance;
	}

	public EihApps getFromEihAppsByAppId(int id) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_APPS);
		EihApps eihApps = (EihApps) dao.getFromDB(factory, "EihApps", id, "app_id");
		return eihApps;
	}

	public EihApps getFromEihAppsByAppName(String name) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_APPS);
		EihApps eihApps = (EihApps) dao.getFromDB(factory, "EihApps", name, "app_name");
		return eihApps;
	}
	
	public List<EihAccessInfo> getAllEihAccessInfos() {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_ACCESS_INFO);
		List<EihAccessInfo> eihAccessInfos = dao.getFromDb(factory, "EihAccessInfo");
		return eihAccessInfos;
	}
	
	public List<EihAccessInfo> getAllEihAccessInfosByUID(int uid) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_ACCESS_INFO);
		List<EihAccessInfo> eihAccessInfos = dao.getListByQuery(factory, "from EihAccessInfo where uid=" + uid);
		return eihAccessInfos;
	}

	public List<EihApps> getAllFromEihApps() {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_APPS);
		List<EihApps> eihAppsList = dao.getFromDb(factory, "EihApps");
		return eihAppsList;
	}

	public void insertIntoEihAppRoles(int appId) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_APP_ROLES);
		EihAppRoles eihAppRoles = new EihAppRoles();
		eihAppRoles.setAppId(appId);
		dao.insert(factory, eihAppRoles);
	}

	public void insertIntoEihAccessInfo(int uid, int roleId) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_ACCESS_INFO);
		EihAccessInfo eihAccessInfo = new EihAccessInfo();
		eihAccessInfo.setUid(uid);
		eihAccessInfo.setRole_id(roleId);
		eihAccessInfo.setActive(1);
		eihAccessInfo.setFrom_date(new Date());
		dao.insert(factory, eihAccessInfo);
	}
	
	public void inactivateEihAccessInfoByRoleId(int roleId) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_ACCESS_INFO);
		String query = "from EihAccessInfo where role_id=" + roleId;
		List<EihAccessInfo> eihAccessInfos = (List<EihAccessInfo>) dao.getListByQuery(factory, query);
		System.out.println("****************TESTING************");
		for(EihAccessInfo eihAccessInfo : eihAccessInfos) {
			System.out.println("ID :: " + eihAccessInfo.getId());
			System.out.println("RoleID :: " + eihAccessInfo.getRole_id());
		}
		for(EihAccessInfo eihAccessInfo : eihAccessInfos) {
			inactivateEihAccessInfo(eihAccessInfo, dao);
		}
	}
	
	public void inactivateEihAccessInfo(EihAccessInfo eihAccessInfo, Dao dao) {
		eihAccessInfo.setActive(0);
		eihAccessInfo.setTo_date(new Date());
		dao.update(factory, eihAccessInfo);
	}
	
	public void updateEihAccessInfo(int uid, int roleId) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_ACCESS_INFO);
		String query = "from EihAccessInfo where uid=" + uid + " and role_id=" + roleId;
		EihAccessInfo eihAccessInfo = (EihAccessInfo) dao.getByQuery(factory, query);
		
		inactivateEihAccessInfo(eihAccessInfo, dao);
		
		/*eihAccessInfo.setActive(0);
		eihAccessInfo.setTo_date(new Date());
		dao.update(factory, eihAccessInfo);*/
	}

	public int getNewlyCreatedRoleIdFromEihAppRoles(int appId) {
		Dao dao = daoFactory.getDao(EihDaoType.EIH_APP_ROLES);
		EihAppRoles eihAppRoles = (EihAppRoles) dao.getFromDB(factory, "EihAppRoles", appId, "app_id");
		int roleId = eihAppRoles.getRoleId();
		return roleId;
	}

	public String getJsonFromObjectList(List<? extends Object> objList) {
		Gson gson = new Gson();
		String result = gson.toJson(objList);
		return result;
	}

	public String getJsonFromObject(Object obj) {
		Gson gson = new Gson();
		String result = gson.toJson(obj);
		return result;
	}
	
	public static void main(String[] args) {
		EihController controller = EihController.getInstance("jdbc:mysql://localhost:3306/", "EIH_AUTHORIZATION");
		EihApps res1 = controller.getFromEihAppsByAppName("");
	}
}
