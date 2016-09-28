package com.sarat.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sarat.entity.Device;
import com.sarat.service.DeviceService;

@Controller
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView view = new ModelAndView();
		view.addObject("deviceList", deviceService.findAllDevices());
		view.setViewName("devicelist");
		return view;
		
	}
	@RequestMapping(path="/home/adddevice",method=RequestMethod.GET)
	public ModelAndView addDevice(){
		ModelAndView view = new ModelAndView();
		view.addObject("device", new Device());
		view.setViewName("deviceform");
		return view;
	}
	@RequestMapping(path="/home/adddevice",method=RequestMethod.POST)
	public ModelAndView addDevice1(@ModelAttribute("device") Device device){
		ModelAndView view=new ModelAndView();
		deviceService.saveDevice(device);
		view.setViewName("redirect:/home");
		return view;
	}
	
	@RequestMapping(path="/home/{id}/update",method=RequestMethod.GET)
	public ModelAndView updateDevice(@PathVariable("id") int id){
		ModelAndView view=new ModelAndView();
		Device device=deviceService.findById(id);
		view.addObject("device",device);
	    view.setViewName("deviceform");
	return view;
	}
	
	@RequestMapping(path="/home/{id}/delete",method=RequestMethod.GET)
	public ModelAndView deleteDevice(@PathVariable("id") int id, Model model){
		ModelAndView view=new ModelAndView();
		deviceService.deleteDeviceById(id);
		view.setViewName("redirect:/home");
		return view;
	}
	
	@RequestMapping(value = "/deices/{id}", method = RequestMethod.GET)
	public ModelAndView showUser(@PathVariable("id") int id, Model model) {
		ModelAndView view=new ModelAndView();
		Device device = deviceService.findById(id);
		if (device == null) {
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("device", device);
		view.setViewName("showuser");
		return view;

	}
	
}
