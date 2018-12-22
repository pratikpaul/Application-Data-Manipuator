package com.self.appData;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.self.appData.dao.AccessInfoDao;
import com.self.appData.dao.AppDao;
import com.self.appData.dao.AppDaoFactory;
import com.self.appData.dao.AppDaoType;
import com.self.appData.dto.AccessInfo;
import com.self.appData.dto.AccessPrivileges;
import com.self.appData.sessionFactoryEst.EstablishAppSessionFactory;

public class AppController {

	private static volatile AppController instance = null;
	private static AppDaoFactory appDaoFactory = new AppDaoFactory();
	private static String jdbcUrl;
	private static String schema;
	private static SessionFactory factory = null;

	private AppController(String jdbcUrl, String schema) {
		this.jdbcUrl = jdbcUrl;
		this.schema = schema;
		factory = EstablishAppSessionFactory.createSessionFactory(jdbcUrl, schema);
	}

	public static AppController getInstance(String jdbcUrl, String schema) {
		if (instance == null) {
			synchronized (AppController.class) {
				if (instance == null) {
					instance = new AppController(jdbcUrl, schema);
				}
			}
		}
		return instance;
	}

	public List<AccessInfo> getAllFromAccessInfo() {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_INFO);
		List<AccessInfo> accessInfos = dao.getFromDb(factory, "AccessInfo");
		return accessInfos;
	}

	public List<AccessPrivileges> getAllFromAccessPrivileges() {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_PRIVILIGES);
		List<AccessPrivileges> accessPrivileges = dao.getFromDb(factory, "AccessPrivileges");
		return accessPrivileges;
	}

	public void insertIntoAccessPrivileges(String accessType) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_PRIVILIGES);
		AccessPrivileges accessPrivileges = new AccessPrivileges();
		accessPrivileges.setAccess_type(accessType);
		accessPrivileges.setCreation_date(new Date());
		dao.insert(factory, accessPrivileges);
	}

	public void insertIntoAccessPrivileges(String accessType, String user) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_PRIVILIGES);
		AccessPrivileges accessPrivileges = new AccessPrivileges();
		accessPrivileges.setAccess_type(accessType);
		accessPrivileges.setCreated_by(user);
		accessPrivileges.setCreation_date(new Date());
		dao.insert(factory, accessPrivileges);
	}

	public void updateAccessInfo(int id, String role, String access, String user) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_INFO);
		String query = "from AccessInfo where id = " + id;
		AccessInfo accessInfo = (AccessInfo)dao.getByQuery(factory, query);
		accessInfo.setRole(role);
		accessInfo.setAccess(access);
		accessInfo.setModification_date(new Date());
		accessInfo.setModified_by(user);
		dao.update(factory, accessInfo);
	}

	public void updateAccessPrivileges(int accessId, String accessType, String user) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_PRIVILIGES);
		AccessPrivileges accessPrivileges = new AccessPrivileges();
		accessPrivileges.setAccess_id(accessId);
		accessPrivileges.setAccess_type(accessType);
		accessPrivileges.setModification_date(new Date());
		accessPrivileges.setModified_by(user);
		dao.update(factory, accessPrivileges);
	}

	public AccessInfo getAccessInfoByRoleId(int roleId) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_INFO);
		String query = "from AccessInfo where role_id=" + roleId + " and mark_delete = 0";
		AccessInfo accessInfo = (AccessInfo) dao.getByQuery(factory, query);
		return accessInfo;
	}

	public AccessInfo getAccessInfoByAccessType(String access) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_INFO);
		AccessInfo accessInfo = (AccessInfo) dao.getFromDB(factory, "AccessInfo", access, "access");
		return accessInfo;
	}

	public String getAccessInfoRole(String access) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_INFO);
		AccessInfo accessInfo = (AccessInfo) dao.getFromDB(factory, "AccessInfo", access, "access");
		String result = "";
		if (accessInfo == null) {
			result = "NOT FOUND";
		} else {
			result = accessInfo.getRole();
		}
		return result;
	}
	
	public void logicalDeleteAccessInfoById(int id) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_INFO);
		String query = "from AccessInfo where id = " + id;
		AccessInfo accessInfo = (AccessInfo) dao.getByQuery(factory, query);
		accessInfo.setMark_delete(1);
		dao.update(factory, accessInfo);
	}
	
	

	public void insertIntoAccessInfo(int roleId, String roleName, String access, String user) {
		AppDao dao = appDaoFactory.getDao(AppDaoType.ACCESS_INFO);
		AccessInfo accessInfo = new AccessInfo();
		accessInfo.setAccess(access);
		accessInfo.setRole_id(roleId);
		accessInfo.setRole(roleName);
		accessInfo.setCreated_by(user);
		accessInfo.setCreation_date(new Date());
		dao.insert(factory, accessInfo);
	}

	public String getJsonFromObjectList(List<? extends Object> objList) {
		Gson gson = new Gson();
		String json = gson.toJson(objList);
		return json;
	}

	public String getJsonFromObject(Object obj) {
		Gson gson = new Gson();
		String result = gson.toJson(obj);
		return result;
	}

	/*
	 * public static void main(String[] args) { AppController controller =
	 * AppController.getInstance("jdbc:mysql://localhost:3306/", "self");
	 * List<AccessPrivileges> res = controller.getAllFromAccessPrivileges();
	 * List<AccessInfo> res2 = controller.getAllFromAccessInfo();
	 * controller.updateAccessPrivileges(4, "PUBLISHNEW", "Clark");
	 * List<AccessPrivileges> res3 = controller.getAllFromAccessPrivileges(); String
	 * res4 = controller.getAccessInfoRole("publisher"); AccessInfo res5 = new
	 * AccessInfoDao().getByQuery(controller.factory,
	 * "from AccessInfo where id = 1");
	 * controller.insertIntoAccessPrivileges("Producer", "Lex Luthor");;
	 * System.out.println(controller.getJsonFromObjectList(res));
	 * System.out.println(controller.getJsonFromObjectList(res2));
	 * System.out.println(controller.getJsonFromObjectList(res3));
	 * System.out.println(res4);
	 * System.out.println(controller.getJsonFromObject(res5)); }
	 */
}
