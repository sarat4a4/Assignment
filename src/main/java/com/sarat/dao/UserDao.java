package com.sarat.dao;

import com.sarat.entity.User;

public interface UserDao {
	void saveUser(User user);
	
	User loadByUsername(String username)throws Exception;
	
}
