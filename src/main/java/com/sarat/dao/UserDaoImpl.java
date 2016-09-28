package com.sarat.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sarat.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
 
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
	    return sessionFactory.getCurrentSession();
	 }
	
	@Override
	public void saveUser(User user) {
		getSession().save(user);		
	}

	@Override
	public User loadByUsername(String username) throws Exception {
		try{
			return (User) getSession()
						.createCriteria(User.class)
						.add(Restrictions.eq("userName", username))
						.uniqueResult();
		} catch(HibernateException e){
			throw new Exception("Something went wrong", e);
		}
	}
	

}
