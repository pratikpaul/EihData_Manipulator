package com.self.eihDrive.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public interface Dao<T> {
	
	public void insert(SessionFactory factory, T input);
	public void update(SessionFactory factory, T input);
	public Boolean delete(SessionFactory factory, T input);
	public List<T> getFromDb(SessionFactory factory, String fromTable);
	public T getFromDb(SessionFactory factory, String fromTable, int id);
	public T getFromDB(SessionFactory factory, String fromTable, String name);
	public T getFromDB(SessionFactory factory, String fromTable, Object value);
	public T getFromDB(SessionFactory factory, String fromTable, Object value, String col);
	public T getFromDB(SessionFactory factory, String fromTable, Object value1, Object value2);
	public T getByQuery(SessionFactory factory, String query);
	public List<T> getListByQuery(SessionFactory factory, String query);
}
