package com.self.appData.dao;

public class AppDaoFactory {
	private static AccessInfoDao accessInfoDao = null;
	private static AccessPrivilegesDao accessPrivilegesDao = null;

	public AppDao getDao(AppDaoType daoType) {

		if (daoType == null) {
			return null;
		} else if (daoType == AppDaoType.ACCESS_INFO) {
			if (accessInfoDao == null)
				accessInfoDao = new AccessInfoDao();
			return accessInfoDao;
		} else if (daoType == AppDaoType.ACCESS_PRIVILIGES) {
			if (accessPrivilegesDao == null)
				accessPrivilegesDao = new AccessPrivilegesDao();
			return accessPrivilegesDao;
		}

		return null;
	}
}
