package com.serve.dao;

import com.serve.models.UserModel;

public interface LoginDAO {
	boolean add(UserModel users);
	boolean update(UserModel users);
	boolean delete(UserModel users);
	UserModel fetch(UserModel users);
}
