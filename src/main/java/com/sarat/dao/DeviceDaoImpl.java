package com.sarat.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sarat.entity.Device;


@Repository
public class DeviceDaoImpl implements DeviceDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	 protected Session getSession(){
	    return sessionFactory.getCurrentSession();
	 }
	   
	@Override
	public Device deviceById(int id) {
		return getSession().get(Device.class, id);
	}

	@Override
	public void saveDevice(Device device) {
		getSession().saveOrUpdate(device);	
	}

	@Override
	public void deleteDeviceById(int id) {
		Device device=(Device)getSession().get(Device.class, id);
		getSession().delete(device);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Device> findAllDevices() {
		Criteria crit=getSession().createCriteria(Device.class);	
		return (List<Device>) crit.list();
	}

	@Override
	public void updateDevice(Device device) {
		getSession().update(device);
		
	}	
}
