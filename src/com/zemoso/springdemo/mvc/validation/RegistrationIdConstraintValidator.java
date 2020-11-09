package com.zemoso.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegistrationIdConstraintValidator implements ConstraintValidator<RegistrationId,String> {
	
	private String registerPrefix;
	@Override
    public void initialize(RegistrationId id) {
		registerPrefix = id.value();
    }

	@Override
	public boolean isValid(String theId, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		if(theId!=null) {
			result = theId.startsWith(registerPrefix);
		}
		else {
			return true;
		}
		return result;
	}

}
