package com.self.appData.behaviour;

import org.hibernate.SessionFactory;

public interface TransBehaviourForBool<T> {
	public Boolean act(SessionFactory factory, T obj);
}
