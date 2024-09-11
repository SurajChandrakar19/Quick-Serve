package com.serve.dao;

import com.serve.interfaces.Table;

public interface MainDAO {
	boolean add(Table table);
	boolean update(Table table);
	boolean delete(Table tbale);
	Table fetch(Table table);
}
