package com.self.appData.behaviour;

import org.hibernate.SessionFactory;

public interface TransBehaviourForDelete<T> {
	public Boolean act(SessionFactory factory, Object input, Class<?> c);
}
