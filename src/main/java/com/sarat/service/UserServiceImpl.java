package com.sarat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarat.dao.UserDao;
import com.sarat.entity.User;

@Transactional
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
    private UserDao dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void registerUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		dao.saveUser(user);	
	}

	@Override
	public User loadByUsername(String username) throws Exception {
		try{
			return dao.loadByUsername(username);
		} catch(Exception e){
			throw new Exception(e.getMessage(),e);
		}
	}	
}
