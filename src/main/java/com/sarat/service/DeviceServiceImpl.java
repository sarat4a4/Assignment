package com.sarat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarat.dao.DeviceDao;
import com.sarat.entity.Device;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService{
	@Autowired
	private DeviceDao dao;
	
	@Override
	public void saveDevice(Device device) {
		dao.saveDevice(device);
	}

	@Override
	public void updateDevice(Device device) {
		dao.saveDevice(device);
	}

	@Override
	public void deleteDeviceById(int id) {
		dao.deleteDeviceById(id);
	}

	@Override
	public List<Device> findAllDevices() {
	return dao.findAllDevices();
		
	}

	@Override
	public Device findById(int id) {
		Device device=dao.deviceById(id);
		return device;
	}

}
