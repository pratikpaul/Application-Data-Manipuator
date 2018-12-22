package com.self.appData.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public interface AppDao<T> {
	
	public void insert(SessionFactory factory, T input);
	public void update(SessionFactory factory, T input);
	public Boolean delete(SessionFactory factory, int id);
	public List<T> getFromDb(SessionFactory factory, String fromTable);
	public T getFromDb(SessionFactory factory, String fromTable, int id);
	public T getFromDB(SessionFactory factory, String fromTable, String name);
	public T getFromDB(SessionFactory factory, String fromTable, Object name, String col);
	public T getFromDB(SessionFactory factory, String fromTable, int id, String name);
	public T getByQuery(SessionFactory factory, String query);
	public List<T> getListByQuery(SessionFactory factory, String query);
}
