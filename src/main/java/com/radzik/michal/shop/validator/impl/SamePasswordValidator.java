package com.radzik.michal.shop.validator.impl;

import com.radzik.michal.shop.domain.dto.UserDto;
import com.radzik.michal.shop.validator.SamePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordValidator implements ConstraintValidator<SamePassword, UserDto> {


    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirmPassword());
    }

}
