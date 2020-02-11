package com.project.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.project.customvalidator.DegreeAnnotation;

public class DegreeValidator implements ConstraintValidator<DegreeAnnotation,Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String grp = (String) value;
		if(grp.contains(".") && grp.contains(" "))
			return true;
		return false;
	}

}
