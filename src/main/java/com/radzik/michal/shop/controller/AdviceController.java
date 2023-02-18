package com.radzik.michal.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityExistsException;
import javax.validation.ValidationException;
import java.sql.SQLIntegrityConstraintViolationException;


@RestControllerAdvice
@Slf4j
public class AdviceController {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
        log.error("Not found ", entityNotFoundException);
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleSQLIntegrityConstraintViolationException(Exception uniqueConstraint) {
        log.error("Not unique  ", uniqueConstraint);
    }
}
