package com.sarat.dao;

import java.util.List;

import com.sarat.entity.Device;

public interface DeviceDao {

	Device deviceById(int id);
	void saveDevice(Device device);
	void deleteDeviceById(int id);
	List<Device> findAllDevices();
	void updateDevice(Device device);
	
	
}
