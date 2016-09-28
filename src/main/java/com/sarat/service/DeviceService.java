package com.sarat.service;

import java.util.List;

import com.sarat.entity.Device;

public interface DeviceService {
    
	Device findById(int id);
	
	void saveDevice(Device device);
    
    void updateDevice(Device device);
     
    void deleteDeviceById(int id);
 
    List<Device> findAllDevices(); 

}
