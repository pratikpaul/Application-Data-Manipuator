package com.self.appData.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.self.appData.behaviour.TransBehaviour;
import com.self.appData.behaviour.TransBehaviourForBool;
import com.self.appData.behaviour.TransBehaviourForDelete;
import com.self.appData.behaviour.TransBehaviourForList;
import com.self.appData.behaviour.TransBehaviourForObj;

public abstract class DaoAbstract<T> {
	public TransBehaviourForList<T> transBehaviourForList;
	public TransBehaviour<T> transBehaviour;
	public TransBehaviourForBool<T> transBehaviourForBool;
	public TransBehaviourForObj<T> transBehaviourForObj;
	public TransBehaviourForDelete<T> transBehaviourForDelete;

	public TransBehaviourForDelete<T> getTransBehaviourForDelete() {
		return transBehaviourForDelete;
	}

	public void setTransBehaviourForDelete(TransBehaviourForDelete<T> transBehaviourForDelete) {
		this.transBehaviourForDelete = transBehaviourForDelete;
	}

	public TransBehaviourForBool<T> getTransBehaviourForBool() {
		return transBehaviourForBool;
	}

	public void setTransBehaviourForBool(TransBehaviourForBool<T> transBehaviourForBool) {
		this.transBehaviourForBool = transBehaviourForBool;
	}

	public TransBehaviourForObj<T> getTransBehaviourForObj() {
		return transBehaviourForObj;
	}

	public void setTransBehaviourForObj(TransBehaviourForObj<T> transBehaviourForObj) {
		this.transBehaviourForObj = transBehaviourForObj;
	}

	public TransBehaviourForList<T> getTransBehaviourForList() {
		return transBehaviourForList;
	}

	public void setTransBehaviourForList(TransBehaviourForList<T> transBehaviourForList) {
		this.transBehaviourForList = transBehaviourForList;
	}

	public TransBehaviour<T> getTransBehaviour() {
		return transBehaviour;
	}

	public void setTransBehaviour(TransBehaviour<T> transbehaviour) {
		this.transBehaviour = transbehaviour;
	}

	public void justTakeAction(SessionFactory factory, T obj) {
		transBehaviour.act(factory, obj);
	}
	
	public Boolean takeActionForDeletion(SessionFactory factory, Object input, Class<?> c) {
		return transBehaviourForDelete.act(factory, input, c);
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
