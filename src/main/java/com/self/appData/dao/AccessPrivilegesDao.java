package com.self.appData.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.self.appData.behaviour.TransToGetFromDB;
import com.self.appData.behaviour.TransToInsert;
import com.self.appData.behaviour.TransToUpdate;
import com.self.appData.dto.AccessPrivileges;

public class AccessPrivilegesDao extends DaoAbstract<AccessPrivileges> implements AppDao<AccessPrivileges> {

	
	public void insert(SessionFactory factory, AccessPrivileges input) {
		setTransBehaviour(new TransToInsert<AccessPrivileges>());
		justTakeAction(factory, input);
	}

	public void update(SessionFactory factory, AccessPrivileges input) {
		
		setTransBehaviour(new TransToUpdate<AccessPrivileges>());
		justTakeAction(factory, input);
		
	}

	public Boolean delete(SessionFactory factory, int id) {
		return null;
	}

	public List<AccessPrivileges> getFromDb(SessionFactory factory, String fromTable) {
		
		setTransBehaviourForList(new TransToGetFromDB<AccessPrivileges>());
		List<AccessPrivileges> result = takeActionAndGetList(factory, fromTable);
		
		return result;
	}

	public AccessPrivileges getFromDb(SessionFactory factory, String fromTable, int id) {
		return null;
	}

	public AccessPrivileges getFromDB(SessionFactory factory, String fromTable, String name) {
		return null;
	}

	public AccessPrivileges getFromDB(SessionFactory factory, String fromTable, int id, String name) {
		return null;
	}

	public AccessPrivileges getByQuery(SessionFactory factory, String query) {
		return null;
	}

	public List<AccessPrivileges> getListByQuery(SessionFactory factory, String query) {
		return null;
	}

	public AccessPrivileges getFromDB(SessionFactory factory, String fromTable, Object name, String col) {
		// TODO Auto-generated method stub
		return null;
	}

}
