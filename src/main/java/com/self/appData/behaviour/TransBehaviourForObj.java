package com.self.appData.behaviour;

import org.hibernate.SessionFactory;

public interface TransBehaviourForObj<T> {
	public T act(SessionFactory factory, Object obj1, Object obj2, Object obj3);
	public T act(SessionFactory factory, Object obj1, Object obj2);
	public T act(SessionFactory factory, Object obj1);
}
