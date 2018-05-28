package com.sap.exception;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
	private final Logger logger = LoggerFactory.getLogger(ApiControllerAdvice.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DataIntegrityViolationException.class})
    public ApiError handleDataIntegrityViolation(HttpServletRequest request, Exception ex){
        logger.error(String.format("Data integrity violation handle on %s at method %s", request.getRequestURI(),request.getMethod()));
        return new ApiError(HttpStatus.BAD_REQUEST,"Parameter not found",request.getRequestURI(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public ApiError handleEntityNotFound(HttpServletRequest request, Exception ex){
        logger.error(String.format("Entity not found exception handle on %s at method %s", request.getRequestURI(),request.getMethod()));
        return new ApiError(HttpStatus.BAD_REQUEST,"Entity not found",request.getRequestURI(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({JpaSystemException.class})
    public ApiError handleJpaSystem(HttpServletRequest request, Exception ex){
        logger.error(String.format("Jpa system exception handle on %s at method %s", request.getRequestURI(),request.getMethod()));
        return new ApiError(HttpStatus.BAD_REQUEST,"Primary key not found",request.getRequestURI(), ex);
    }
}
