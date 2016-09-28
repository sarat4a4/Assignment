package com.sarat.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sarat.entity.User;
import com.sarat.service.UserService;

public class UserFormValidator implements Validator {

	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "NotEmpty.userForm.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
		if(user.getPhoneNumber()==null){
			errors.rejectValue("phoneNumber", "NotEmpty.userForm.phone");
		}
		if(user.getUserName().equalsIgnoreCase("none")){
			errors.rejectValue("userName", "NotEmpty.userForm.name");
		}

		if (!user.getPassword().equals(user.getPassword())) {
			errors.rejectValue("password", "NotEmpty.userform.password");
		}
		
	}

	

}
