package com.sarat.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "device")
public class Device implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5282446396503409340L;

	@Id
	@Column(name="device_id",nullable=false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deviceId;
	
	@Column(name="divice_name",nullable=false)
	private String deviceName;
	
	@Column(name="device_version",nullable=false)
	private String deviceVersion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="expiry_date")
	private Date expiryDate;
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
		
	}
	
