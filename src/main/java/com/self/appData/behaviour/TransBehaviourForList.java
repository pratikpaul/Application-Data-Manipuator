package com.self.appData.behaviour;

import java.util.List;

import org.hibernate.SessionFactory;

public interface TransBehaviourForList<T> {
	public List<T> act(SessionFactory factory, Object obj);
}
