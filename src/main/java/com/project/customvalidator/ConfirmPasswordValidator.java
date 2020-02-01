package com.project.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.project.validator.SignUp;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword,Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		SignUp signup = (SignUp)value;
		return signup.getPassword().equals(signup.getConfirmpassword());
	}

}
