package com.sarat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sarat.entity.User;
import com.sarat.service.UserService;
import com.sarat.validators.UserFormValidator;

@Controller
public class SignUpController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView view = new ModelAndView();
		view.setViewName("registration");
		view.addObject("user", new User());
		return view;
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public ModelAndView doSignUp(@ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView view = new ModelAndView();
		UserFormValidator userFormValidator = new UserFormValidator();
		userFormValidator.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()){
			view.setViewName("redirect:/signup");
		}else{
			try{
				userService.registerUser(user);
				view.addObject("success", "Your registration has been successful. Please login here");
				view.setViewName("redirect:/login");
			}catch(Exception e){
				view.addObject("error", e.getMessage());
				view.setViewName("redirect:/signup");
			}
		}
		return view;
	}

}
