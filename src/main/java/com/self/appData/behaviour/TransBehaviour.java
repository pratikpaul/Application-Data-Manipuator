package com.self.appData.behaviour;

import org.hibernate.SessionFactory;

public interface TransBehaviour<T> {
	public void act(SessionFactory factory, T... obj);
}
