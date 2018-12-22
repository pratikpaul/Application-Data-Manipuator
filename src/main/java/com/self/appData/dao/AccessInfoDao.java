package com.self.appData.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.self.appData.behaviour.TransToLogicallyDeleteById;
import com.self.appData.behaviour.TransToGetByQuery;
import com.self.appData.behaviour.TransToGetBySingleCond;
import com.self.appData.behaviour.TransToGetFromDB;
import com.self.appData.behaviour.TransToGetListByQuery;
import com.self.appData.behaviour.TransToInsert;
import com.self.appData.behaviour.TransToUpdate;
import com.self.appData.dto.AccessInfo;

public class AccessInfoDao extends DaoAbstract<AccessInfo> implements AppDao<AccessInfo> {

	public void insert(SessionFactory factory, AccessInfo input) {
		setTransBehaviour(new TransToInsert<AccessInfo>());
		justTakeAction(factory, input);
	}

	public void update(SessionFactory factory, AccessInfo input) {
		setTransBehaviour(new TransToUpdate<AccessInfo>());
		justTakeAction(factory, input);
	}

	public Boolean delete(SessionFactory factory, int id) {
		setTransBehaviourForDelete(new TransToLogicallyDeleteById<AccessInfo>());
		Boolean outcome = takeActionForDeletion(factory, id, AccessInfo.class);
		return outcome;
	}

	public List<AccessInfo> getFromDb(SessionFactory factory, String fromTable) {

		setTransBehaviourForList(new TransToGetFromDB<AccessInfo>());
		List<AccessInfo> result = takeActionAndGetList(factory, fromTable);

		return result;
	}

	public AccessInfo getFromDb(SessionFactory factory, String fromTable, int id) {
		
		return null;
	}

	public AccessInfo getFromDB(SessionFactory factory, String fromTable, Object name, String col) {

		setTransBehaviourForObj(new TransToGetBySingleCond<AccessInfo>());
		AccessInfo result = takeActionAndGetObj(factory, fromTable, name, col);

		return result;
	}

	public AccessInfo getFromDB(SessionFactory factory, String fromTable, int id, String name) {
		return null;
	}

	public AccessInfo getByQuery(SessionFactory factory, String query) {

		setTransBehaviourForObj(new TransToGetByQuery<AccessInfo>());
		AccessInfo result = takeActionAndGetObj(factory, query);

		return result;
	}

	public List<AccessInfo> getListByQuery(SessionFactory factory, String query) {

		setTransBehaviourForList(new TransToGetListByQuery<AccessInfo>());
		List<AccessInfo> result = takeActionAndGetList(factory, query);

		return result;
	}

	public AccessInfo getFromDB(SessionFactory factory, String fromTable, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
