package com.self.eihDrive.dao;

public class EihDaoFactory {

	private static EihAccessInfoDao eihAccessInfoDao = null;
	private static EihAppRolesDao eihAppRolesDao = null;
	private static EihAppsDao eihAppsDao = null;

	public Dao getDao(EihDaoType daoType) {

		if (daoType == null) {
			return null;
		} else if (daoType == EihDaoType.EIH_ACCESS_INFO) {
			if (eihAccessInfoDao == null)
				eihAccessInfoDao = new EihAccessInfoDao();
			return eihAccessInfoDao;
		} else if (daoType == EihDaoType.EIH_APP_ROLES) {
			if (eihAppRolesDao == null)
				eihAppRolesDao = new EihAppRolesDao();
			return eihAppRolesDao;
		} else if (daoType == EihDaoType.EIH_APPS) {
			if (eihAppsDao == null)
				eihAppsDao = new EihAppsDao();
			return eihAppsDao;
		}

		return null;
	}
}
