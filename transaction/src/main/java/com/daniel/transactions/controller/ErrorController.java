package com.daniel.transactions.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.daniel.transactions.exception.ErrorResponse;
import com.daniel.transactions.exception.InvalidRequestException;

/**
 * Error controller to return a formated json error.
 */
@ControllerAdvice
public class ErrorController
{
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    /**
     * Catches an {@link InvalidRequestException} and format to return.
     *
     * @param ex The exception catched.
     * @return {@link ResponseEntity} Returns an error wrapped in the response entity.
     */
    @ExceptionHandler (value = InvalidRequestException.class)
    public ResponseEntity<Object> exception(InvalidRequestException ex)
    {
        logger.info(ex.getMessage() + ex.getParameter());
        logger.error(ex.getMessage() + ex.getParameter(), ex);

        ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus(), ex.getTimeStamp(), ex.getMessage() + ex.getParameter());

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
