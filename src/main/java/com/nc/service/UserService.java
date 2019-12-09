package com.nc.service;

import java.util.List;

import com.nc.pojo.User;

public interface UserService {
	void add(User u);
	void delete(int id);
	void update(User u);
	User get(int id);
	List list();
	
	boolean isExist(String name);
	
	User get(String name, String password);
}
