package com.sarat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6159078512521572926L;
	
	public User(){
		
	}
	
	
    /**
	 * @param userId
	 * @param userName
	 * @param phoneNumber
	 * @param password
	 */
	public User(long userId, String userName, String phoneNumber, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	@Column(name="user_name",nullable=false)
	private String userName;
	
	private String phoneNumber;
	
	@Column(name = "password", nullable = false)
	private String password;

	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
