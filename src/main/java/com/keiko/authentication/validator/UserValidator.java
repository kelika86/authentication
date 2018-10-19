package com.keiko.authentication.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.keiko.authentication.models.User;

@Component
public class UserValidator implements Validator{ //click on Uservalidator before implementing methods so it'll autofill for you
	    
	    // 1
	    @Override
	    public boolean supports(Class<?> clazz) {
	        return User.class.equals(clazz); //User model
	    }
	    
	    // 2
	    @Override
	    public void validate(Object target, Errors errors) {
	        User user = (User) target;
	        
	        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
	            // 3
	            errors.rejectValue("passwordConfirmation", "Match");
	        }         
	    }
}
