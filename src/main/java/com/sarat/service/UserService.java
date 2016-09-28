package com.sarat.service;

import com.sarat.entity.User;

public interface UserService {
	  void registerUser(User user)throws Exception;
	  
	  User loadByUsername(String username)throws Exception;
}
